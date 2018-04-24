package com.rjp.sorrydiaodemo.bluetooth;

import android.bluetooth.BluetoothDevice;

public class BLEUtilBean
{
  private BluetoothDevice device;
  private int status;
  private String toastStr;
  
  public BluetoothDevice getDevice()
  {
    return this.device;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public String getToastStr()
  {
    return this.toastStr;
  }
  
  public void setDevice(BluetoothDevice paramBluetoothDevice)
  {
    this.device = paramBluetoothDevice;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public void setToastStr(String paramString)
  {
    this.toastStr = paramString;
  }
}


/* Location:              D:\Android\NewTechnique\UCDemo\work\123res\classes-dex2jar.jar!\net\hlz\prt\bean\BLEUtilBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */