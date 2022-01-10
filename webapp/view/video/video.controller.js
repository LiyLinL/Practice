sap.ui.define(['sap/ui/core/mvc/Controller'], function (Controller) {
    'use strict';
    return Controller.extend('gen.view.video.video', {
        onInit: function () {
            var me = this;
            var oView = this.getView();
            var oTable = oView.byId('table');
            this.getView().setModel(new sap.ui.model.json.JSONModel({}));
        },
        vOperation: function (type) {
            var that = this,
                video = document.querySelector('video'),
                cvs = document.getElementById('canvas'),
                cxt = cvs.getContext('2d'),
                img = document.getElementById('image');

            const constraints = {
                audio: false,
                video: true,
                video: {
                    facingMode: 'user',
                    autoplay: true,
                    controls: true
                }
            };

            const getCameraStream = (video) => {
                navigator.mediaDevices.getUserMedia(constraints).then(function success(stream) {
                    that.mediaStreamTrack = stream;

                    if ('srcObject' in video) {
                        video.srcObject = stream;
                    } else {
                        // Avoid using this in new browsers, as it is going away.
                        video.src = window.URL.createObjectURL(stream);
                    }
                });
            };

            const draw = (video) => {
                cxt.fillStyle = '#fff';
                cxt.fillRect(0, 0, cvs.width, cvs.height);
                cxt.drawImage(video, 0, 0, 200, 150);
            };

            var imgData = cvs.toDataURL('image/jpeg');

            switch (type) {
                case 'open':
                    getCameraStream(video);
                    break;
                case 'screen':
                    draw(video);
                    break;
                case 'close':
                    that.mediaStreamTrack.getTracks().forEach(function (track) {
                        track.stop();
                    });
                    cxt.clearRect(0, 0, cvs.width, cvs.height);
                    break;
                case 'copy':
                    img.src = imgData;
                    break;
                case 'upload':
                    var data = { imageBase64: imgData };

                    new ajax('http://localhost').post(
                        `/upload/image`,
                        data,
                        'html',
                        function (res) {},
                        function (err) {}
                    );
                    break;
                case 'download':
                    new ajax('http://localhost').get(
                        `/download/image`,
                        'html',
                        function (res) {
                            img.src = res;
                        },
                        function (err) {}
                    );
                    break;
                case 'export':
                    var me = this;
                    var wb = new ExcelJS.Workbook();
                    var blob;
                    var ws = wb.addWorksheet('sheet1');

                    // const imageId2 = wb.addImage({
                    //     base64: imgData,
                    //     extension: 'jpeg'
                    // });

                    // ws.addImage(imageId2, 'A1:B2');
                    new ajax('http://localhost').get(
                        `/test/excel`,
                        'text',
                        function (res) {
                            //解碼
                            var decodedPdfContent = atob(res);
                            //建出uint8陣列
                            var byteArray = new Uint8Array(decodedPdfContent.length);
                            for (var i = 0; i < decodedPdfContent.length; i++) {
                                byteArray[i] = decodedPdfContent.charCodeAt(i);
                            }
                            //輸出Blob
                            blob = new Blob([byteArray.buffer], {
                                type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;base64,'
                            });

                            // saveAs(blob, 'test.xlsx');
                        },
                        function (err) {
                            console.log(err);
                        }
                    );

                    async function readExcel() {
                        //等待解析完畢
                        await wb.xlsx.load(blob);
                    }

                    // readExcel();

                    async function doing() {
                        const buffer = await wb.xlsx.writeBuffer();
                        const fileType =
                            'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet';
                        const blob = new Blob([buffer], { type: fileType });
                        saveAs(blob, 'xxxxx.xlsx');
                    }
                    doing();

                    break;
            }
        }
    });
});
