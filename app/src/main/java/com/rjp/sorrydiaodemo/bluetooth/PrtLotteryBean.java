package com.rjp.sorrydiaodemo.bluetooth;

public class PrtLotteryBean
{
  private int flagLottery;
  private byte[] lotteryData;
  private byte[] lotteryDataWelfareHead;
  
  public int getFlagLottery()
  {
    return this.flagLottery;
  }
  
  public byte[] getLotteryData()
  {
    return this.lotteryData;
  }
  
  public byte[] getLotteryDataWelfareHead()
  {
    return this.lotteryDataWelfareHead;
  }
  
  public void setFlagLottery(int paramInt)
  {
    this.flagLottery = paramInt;
  }
  
  public void setLotteryData(byte[] paramArrayOfByte)
  {
    this.lotteryData = paramArrayOfByte;
  }
  
  public void setLotteryDataWelfareHead(byte[] paramArrayOfByte)
  {
    this.lotteryDataWelfareHead = paramArrayOfByte;
  }
}