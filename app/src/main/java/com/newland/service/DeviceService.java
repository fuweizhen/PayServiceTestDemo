package com.newland.service;

import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.jl.Ddi;
import com.newland.aidl.beeper.AidlBeeper;
import com.newland.aidl.deviceInfo.AidlDeviceInfo;
import com.newland.aidl.deviceService.AidlDeviceService;
import com.newland.aidl.iccard.AidlICCard;
import com.newland.aidl.led.AidlLED;
import com.newland.aidl.pboc.AidlCheckCardListener;
import com.newland.aidl.pboc.AidlPBOC;
import com.newland.aidl.pboc.AidlPBOCListener;
import com.newland.aidl.pinpad.AidlPinpad;
import com.newland.aidl.pinpad.AidlPinpadListener;
import com.newland.aidl.pinpad.TusnData;
import com.newland.aidl.printer.AidlPrinter;
import com.newland.aidl.printer.AidlPrinterListener;
import com.newland.aidl.rfcard.AidlRFCard;
import com.newland.aidl.rfcard.PowerOnRFResult;
import com.newland.aidl.scanner.AidlScanner;
import com.newland.aidl.scanner.AidlScannerListener;
import com.newland.aidl.serialComm.AidlSerialComm;
import com.newland.aidl.terminal.AidlTerminalManage;

/**
 * Created by Mark on 2018/3/28.
 */

public class DeviceService extends Service{

    private Ddi hal;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        hal = new Ddi();
        return mDeviceBinder;
    }


    private AidlDeviceService.Stub mDeviceBinder = new AidlDeviceService.Stub() {
        @Override
        public IBinder getDeviceInfo() throws RemoteException {
            return new AidlDeviceInfo.Stub() {
                @Override
                public String getTUSN() throws RemoteException {
                    return null;
                }

                @Override
                public String getSN() throws RemoteException {
                    return null;
                }

                @Override
                public String getCSN() throws RemoteException {
                    return null;
                }

                @Override
                public String getVID() throws RemoteException {
                    return null;
                }

                @Override
                public String getVName() throws RemoteException {
                    return null;
                }

                @Override
                public String getKSN() throws RemoteException {
                    return null;
                }

                @Override
                public String getAndroidOSVersion() throws RemoteException {
                    return null;
                }

                @Override
                public String getAndroidKernelVersion() throws RemoteException {
                    return null;
                }

                @Override
                public String getFirmwareVersion() throws RemoteException {
                    return null;
                }

                @Override
                public String getDeviceModel() throws RemoteException {
                    return null;
                }
            };
        }

        @Override
        public IBinder getPBOC() throws RemoteException {
            return new AidlPBOC.Stub() {
                @Override
                public void checkCard(Bundle option, AidlCheckCardListener listener) throws RemoteException {

                }

                @Override
                public void cancelCheckCard() throws RemoteException {

                }

                @Override
                public void startPBOC(int pbocType, Bundle option, AidlPBOCListener listener) throws RemoteException {

                }

                @Override
                public void selectApplication(byte[] aid) throws RemoteException {

                }

                @Override
                public void importAmount(long amount) throws RemoteException {

                }

                @Override
                public void confirmPin(int oper, byte[] pin) throws RemoteException {

                }

                @Override
                public void confirmCardInfo(boolean isConfirm) throws RemoteException {

                }

                @Override
                public void confirmCertInfo(boolean isConfirm) throws RemoteException {

                }

                @Override
                public void importOnlineResult(Bundle data) throws RemoteException {

                }

                @Override
                public void endPboc() throws RemoteException {

                }

                @Override
                public void setEmvData(int tag, byte[] data) throws RemoteException {

                }

                @Override
                public String readKernelData(int[] taglist) throws RemoteException {
                    return null;
                }

                @Override
                public String readTransData(int tag) throws RemoteException {
                    return null;
                }

                @Override
                public boolean updateAID(int operation, String dataSource) throws RemoteException {
                    return false;
                }

                @Override
                public boolean updateCAPK(int operation, String dataSource) throws RemoteException {
                    return false;
                }
            };
        }

        @Override
        public IBinder getPinpad() throws RemoteException {
            return new AidlPinpad.Stub() {
                @Override
                public boolean loadTEK(byte[] key, byte[] checkValue) throws RemoteException {
                    return false;
                }

                @Override
                public boolean loadTMKByTEK(int keyId, byte[] key, byte[] checkValue) throws RemoteException {
                    return false;
                }

                @Override
                public boolean loadMainKey(int mkIndex, byte[] keyValue, byte[] kcv) throws RemoteException {
                    return false;
                }

                @Override
                public boolean loadMainKeyByPlaintext(int keyId, byte[] keyValue, byte[] kcv) throws RemoteException {
                    return false;
                }

                @Override
                public boolean loadWorkKey(int keyType, int mkIndex, int wkIndex, byte[] keyValue, byte[] kcv) throws RemoteException {
                    return false;
                }

                @Override
                public byte[] calcMAC(int macMode, int macIndex, byte[] data, byte[] cbcData) throws RemoteException {
                    return new byte[0];
                }

                @Override
                public byte[] encryptData(int encryptMode, int keyIndex, byte[] data, byte[] cbcData) throws RemoteException {
                    return new byte[0];
                }

                @Override
                public byte[] decryptData(int decryptMode, int keyIndex, byte[] data, byte[] cbcData) throws RemoteException {
                    return new byte[0];
                }

                @Override
                public byte[] setPinpadLayout(byte[] layout) throws RemoteException {
                    return new byte[0];
                }

                @Override
                public void startPininput(Bundle param, AidlPinpadListener listener) throws RemoteException {

                }

                @Override
                public String getRandom() throws RemoteException {
                    return null;
                }

                @Override
                public void cancelPininput() throws RemoteException {

                }

                @Override
                public TusnData getTusnInfo(String radom) throws RemoteException {
                    return null;
                }

                @Override
                public void setKeyAlgorithm(int keyAlgorithm) throws RemoteException {

                }

                @Override
                public boolean isSM4Enabled() throws RemoteException {
                    return false;
                }
            };
        }

        @Override
        public IBinder getPrinter() throws RemoteException {
            return new AidlPrinter.Stub() {
                @Override
                public void addText(Bundle format, String text) throws RemoteException {

                }

                @Override
                public void paperSkip(int line) throws RemoteException {

                }

                @Override
                public void addPicture(Bundle format, Bitmap bitmap) throws RemoteException {

                }

                @Override
                public void addBarCode(Bundle format, String barCode) throws RemoteException {

                }

                @Override
                public void addQrCode(Bundle format, String qrCode) throws RemoteException {

                }

                @Override
                public void setSpace(int ySpace) throws RemoteException {

                }

                @Override
                public void startPrinter(AidlPrinterListener listener) throws RemoteException {

                }

                @Override
                public String getStatus() throws RemoteException {
                    return null;
                }
            };
        }

        @Override
        public IBinder getICCard() throws RemoteException {
            return new AidlICCard.Stub() {
                @Override
                public byte[] powerOn(int cardSlot, int cardType) throws RemoteException {
                    int ret = -1;
                    byte[] atrBuf = new byte[50];
                    byte[] atr = null;
                    ret = hal.ddi_iccpsam_poweron(cardSlot, atrBuf);

                    if (ret == 0){
                        atr = new byte[atrBuf[0]];
                        System.arraycopy(atrBuf, 1, atr, 0,atr.length);
                    }

                    return atr;
                }

                @Override
                public byte[] call(int cardSlot, int cardType, byte[] data, int timeout) throws RemoteException {
                    int ret = -1;
                    byte[]buff = new byte[300];
                    int []buffLen =new int[1];
                    ret = hal.ddi_iccpsam_exchange_apdu(cardSlot, data, data.length, buff, buffLen, 300);
                    byte[]r_apdu = null;

                    if (ret == 0){
                        r_apdu = new byte[buffLen[0]];
                        System.arraycopy(buff, 0, r_apdu,0, buffLen[0]);
                    }

                    return r_apdu;
                }

                @Override
                public void powerOff(int cardSlot, int cardType) throws RemoteException {
                    int ret = -1;

                    ret = hal.ddi_iccpsam_poweroff(cardSlot);
                }

                @Override
                public boolean isCardExist(int cardSlot) throws RemoteException {

                    int ret = -1;
                    boolean cardExist = false;

                    ret = hal.ddi_iccpsam_get_status(cardSlot);

                    switch (ret){
                        case 2:
                        case 3:
                            cardExist = true;
                            break;
                        default:
                            cardExist = false;
                            break;
                    }

                    return cardExist;
                }
            };
        }

        @Override
        public IBinder getRFCard() throws RemoteException {
            return new AidlRFCard.Stub() {
                @Override
                public PowerOnRFResult powerOn(int[] cardTypes, int timeout) throws RemoteException {
                    int ret = 0;
                    int types = 0;
                    PowerOnRFResult powerOnRFResult = new PowerOnRFResult();

                    for (int type :
                            cardTypes) {
                        switch (type) {
                            case 0x01:
                                types |= 0x01;
                                break;
                            case 0x02:
                                types |= 0x02;
                                break;
                            case 0x04:
                                types |= 0x04;
                                break;
                        }

                        ret = hal.ddi_rf_poweron(types);

                        if (ret == 0) {
                            ret = hal.ddi_rf_get_status();

                            switch (ret) {
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    powerOnRFResult.setRfcardType(0x01);
                                    break;
                                case 4:
                                    powerOnRFResult.setRfcardType(0x02);
                                    break;
                                case 5:
                                    powerOnRFResult.setRfcardType(0x04);
                                    break;
                                case 6:
                                    powerOnRFResult.setRfcardType(0x04);
                                    break;
                                case 7:
                                    powerOnRFResult.setRfcardType(0x04);
                                    break;
                            }
                        }
                    }

                    return powerOnRFResult;
                }

                @Override
                public byte[] call(byte[] reqData, int timeout) throws RemoteException {
                    int ret = -1;
                    byte[] buff = new byte[300];
                    int [] bufflen = new int[1];
                    ret = hal.ddi_rf_exchange_apdu(reqData, reqData.length, buff, bufflen, 300);
                    byte[] r_apdu = null;
                    if (ret == 0){
                        r_apdu = new byte[bufflen[0]];
                        System.arraycopy(buff, 0, r_apdu, 0, bufflen[0]);
                    }
                    return r_apdu;
                }

                @Override
                public void powerOff() throws RemoteException {
                    hal.ddi_rf_poweroff();
                }

                @Override
                public boolean authenticate(int keyMode, byte[] cardSerialNo, int blockNo, byte[] key) throws RemoteException {
                    return false;
                }

                @Override
                public boolean writeData(int blockNo, byte[] data) throws RemoteException {
                    return false;
                }

                @Override
                public byte[] readData(int blockNo) throws RemoteException {
                    return new byte[0];
                }

                @Override
                public boolean incrementOper(int blockNo, byte[] data) throws RemoteException {
                    return false;
                }

                @Override
                public boolean decrementOper(int blockNo, byte[] data) throws RemoteException {
                    return false;
                }

                @Override
                public boolean isCardExist() throws RemoteException {
                    boolean exist = false;

                    int ret = -1;

                    ret = hal.ddi_rf_get_status();

                    switch (ret){
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                            exist = true;
                            break;
                        default:
                            exist = false;
                            break;
                    }

                    return exist;
                }
            };
        }

        @Override
        public IBinder getScanner() throws RemoteException {
            return new AidlScanner.Stub() {
                @Override
                public void startScan(int scanType, int timeout, AidlScannerListener listener) throws RemoteException {

                }

                @Override
                public void stopScan() throws RemoteException {

                }
            };
        }

        @Override
        public IBinder getLed() throws RemoteException {
            return new AidlLED.Stub() {
                @Override
                public boolean ledOperation(int color, int operation, int times) throws RemoteException {
                    return false;
                }
            };
        }

        @Override
        public IBinder getBeeper() throws RemoteException {
            return new AidlBeeper.Stub() {
                @Override
                public void startBeep(int msec) throws RemoteException {

                }

                @Override
                public void stopBeep() throws RemoteException {

                }
            };
        }

        @Override
        public IBinder getTerminalManage() throws RemoteException {
            return new AidlTerminalManage.Stub() {
                @Override
                public void setDeviceDate(String date) throws RemoteException {

                }

                @Override
                public String getDeviceDate() throws RemoteException {
                    return null;
                }
            };
        }

        @Override
        public IBinder getSerialComm() throws RemoteException {
            return new AidlSerialComm.Stub() {
                @Override
                public int open() throws RemoteException {
                    return 0;
                }

                @Override
                public int setconfig(int data1, int data2, byte[] buf) throws RemoteException {
                    return 0;
                }

                @Override
                public int ioctl(int cmd, byte[] args) throws RemoteException {
                    return 0;
                }

                @Override
                public int read(byte[] buf, int lengthMax, int timeoutSec) throws RemoteException {
                    return 0;
                }

                @Override
                public int write(byte[] buf, int lengthMax, int timeoutSec) throws RemoteException {
                    return 0;
                }

                @Override
                public int close() throws RemoteException {
                    return 0;
                }
            };
        }
    };
}
