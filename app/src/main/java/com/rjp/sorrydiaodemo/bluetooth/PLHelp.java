package com.rjp.sorrydiaodemo.bluetooth;

import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PLHelp
{
  public static final float BLOCK_L_HEIGHT = 1.1F;
  public static final float DEFAULT_DELTA_Y = 4.038F;
  public static float DELTA_L_Y = 0.0F;
  public static final float DELTA_S_X = 5.3F;
  public static float DELTA_S_Y = 0.0F;
  public static final int FLAG_FOOTBALL_3 = 1;
  public static final int FLAG_FOOTBALL_6 = 2;
  public static final int FLAG_FOOTBALL_8 = 3;
  public static final int FLAG_FOOTBALL_SUPER_LOTTO = 4;
  public static final int FLAG_FOOTBALL_WIN_LOSS_GAME = 8;
  private static final int FLAG_PAGE_MODE = 1;
  private static final int FLAG_STANDARD_MODE = 0;
  public static final int FLAG_WELFARE_3D = 5;
  public static final int FLAG_WELFARE_7LE = 7;
  public static final int FLAG_WELFARE_DOUBLE_BALL = 6;
  public static float INIT_L_X = 0.0F;
  public static final float INIT_L_Y = 4.0F;
  public static float INIT_S_X = 0.0F;
  public static final float INIT_S_Y = 6.3F;
  private static final int LEFT_NUM_FOOTBALL_3 = 31;
  private static final int LEFT_NUM_FOOTBALL_6 = 31;
  private static final int LEFT_NUM_FOOTBALL_8 = 36;
  private static final int LEFT_NUM_FOOTBALL_SUPER_LOTTO = 33;
  private static final int LEFT_NUM_FOOTBALL_WIN_LOSS_GAME = 19;
  public static float RIGHT_BOTTOM_X = 0.0F;
  public static float RIGHT_BOTTOM_Y = 0.0F;
  public static final float WF_BLOCK_HEIGHT = 1.875F;
  public static final float WF_DEFAULT_DELTA_Y = 2.7556F;
  public static final float WF_DELTA_L_X = 4.69F;
  public static float WF_DELTA_L_Y = 4.6306F;
  public static float WF_INIT_LEFT_Y = 0.0F;
  public static final float WF_INIT_LEFT_Y_DEFAULT = 2.821F;
  public static final float WF_INIT_LEFT_Y_HEAD = 0.0F;
  public static float WF_INIT_L_X = 0.0F;
  public static float WF_INIT_RIGHT_X = WF_INIT_L_X + 56.28F + 0.095F;
  public static final float WF_INIT_RIGHT_Y_HEAD = 3.146F;
  public static float WF_RIGHT_BOTTOM_Y = WF_INIT_LEFT_Y + 37.0F * WF_DELTA_L_Y + 0.875F + 1.33F + 2.5F;
  
  static
  {
    DELTA_L_Y = 5.138F;
    INIT_S_X = INIT_L_X + 5.0F;
    DELTA_S_Y = DELTA_L_Y;
    RIGHT_BOTTOM_Y = 4.0F + 35.0F * DELTA_L_Y + 2.2F;
    RIGHT_BOTTOM_X = INIT_S_X + 68.9F;
    WF_INIT_LEFT_Y = 2.821F;
    WF_INIT_L_X = 18.3F;
  }
  
  private static byte[] cmdCutPaper()
  {
    return new byte[] { 29, 86, 66, 0 };
  }
  
  private static byte[] cmdCutPaper30()
  {
    return new byte[] { 29, 86, 48 };
  }
  
  private static byte[] cmdDefFootballBlock()
  {
    return new byte[] { 27, 38, 3, 123, 126, 12, 3, -1, -64, 3, -1, -64, 3, -1, -64, 3, -1, -64, 3, -1, -64, 3, -1, -64, 3, -1, -64, 3, -1, -64, 3, -1, -64, 3, -1, -64, 3, -1, -64, 3, -1, -64, 6, 3, -1, -64, 3, -1, -64, 3, -1, -64, 3, -1, -64, 3, -1, -64, 3, -1, -64, 12, 1, -1, 0, 1, -1, 0, 1, -1, 0, 1, -1, 0, 1, -1, 0, 1, -1, 0, 1, -1, 0, 1, -1, 0, 1, -1, 0, 1, -1, 0, 1, -1, 0, 1, -1, 0, 6, 1, -1, 0, 1, -1, 0, 1, -1, 0, 1, -1, 0, 1, -1, 0, 1, -1, 0 };
  }
  
  private static byte[] cmdDefFootballBlockXL()
  {
    return new byte[] { 27, 38, 3, 91, 92, 12, 31, -1, -16, 31, -1, -16, 31, -1, -16, 31, -1, -16, 31, -1, -16, 31, -1, -16, 31, -1, -16, 31, -1, -16, 31, -1, -16, 31, -1, -16, 31, -1, -16, 31, -1, -16, 9, 31, -1, -16, 31, -1, -16, 31, -1, -16, 31, -1, -16, 31, -1, -16, 31, -1, -16, 31, -1, -16, 31, -1, -16, 31, -1, -16 };
  }
  
  private static byte[] cmdDefWelfareBlock()
  {
    return new byte[] { 27, 38, 3, 97, 102, 12, 15, -1, -32, 15, -1, -32, 15, -1, -32, 15, -1, -32, 15, -1, -32, 15, -1, -32, 15, -1, -32, 15, -1, -32, 15, -1, -32, 15, -1, -32, 15, -1, -32, 15, -1, -32, 5, 15, -1, -32, 15, -1, -32, 15, -1, -32, 15, -1, -32, 15, -1, -32, 12, 63, -1, -4, 63, -1, -4, 63, -1, -4, 63, -1, -4, 63, -1, -4, 63, -1, -4, 63, -1, -4, 63, -1, -4, 63, -1, -4, 63, -1, -4, 63, -1, -4, 63, -1, -4, 8, 63, -1, -4, 63, -1, -4, 63, -1, -4, 63, -1, -4, 63, -1, -4, 63, -1, -4, 63, -1, -4, 63, -1, -4, 12, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 5, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  }
  
  private static byte[] cmdInitPageData()
  {
    return new byte[] { 24 };
  }
  
  private static byte[] cmdInitPageModelSetXY()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(cmdSetX((byte)0, (byte)0));
    localArrayList.add(cmdSetY((byte)0, (byte)0));
    return sysCopy(localArrayList);
  }
  
  private static byte[] cmdMarginLeftInCustomModel()
  {
    return new byte[] { 29, 76, 0, 0 };
  }
  
  private static byte[] cmdMoveUnit()
  {
    return new byte[] { 29, 80, 0, 0 };
  }
  
  private static byte[] cmdNewLine()
  {
    return new byte[] { 10 };
  }
  
  private static byte[] cmdPrintModeChoose(int paramInt)
  {
    if (1 == paramInt) {
      return new byte[] { 27, 76 };
    }
    return new byte[] { 27, 83 };
  }
  
  private static byte[] cmdPrtFootballL()
  {
    return new byte[] { 123, 123, 124 };
  }
  
  private static byte[] cmdPrtFootballS()
  {
    return new byte[] { 125, 125, 126 };
  }
  
  private static byte[] cmdPrtFootballXL()
  {
    return new byte[] { 91, 91, 92 };
  }
  
  private static byte[] cmdPrtWelfareBlock()
  {
    return new byte[] { 97, 97, 98 };
  }
  
  private static byte[] cmdPrtWelfareBlockXL()
  {
    return new byte[] { 101, 101, 102 };
  }
  
  private static byte[] cmdPrtWelfareSquare()
  {
    return new byte[] { 99, 100 };
  }
  
  private static byte[] cmdSetPageSize(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4)
  {
    return new byte[] { 27, 87, 0, 0, 0, 0, paramByte1, paramByte2, paramByte3, paramByte4 };
  }
  
  private static byte[] cmdSetX(byte paramByte1, byte paramByte2)
  {
    return new byte[] { 27, 36, paramByte1, paramByte2 };
  }
  
  private static byte[] cmdSetY(byte paramByte1, byte paramByte2)
  {
    return new byte[] { 29, 36, paramByte1, paramByte2 };
  }
  
  private static byte[] cmdStartPrintPage()
  {
    return new byte[] { 27, 12 };
  }
  
  private static byte[] cmdUserDefCancel()
  {
    return new byte[] { 27, 37, 0 };
  }
  
  private static byte[] cmdUserDefChoose()
  {
    return new byte[] { 27, 37, 1 };
  }
  
  public static byte[] demoBlackBlock()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(cmdInitPageModelSetXY());
    int i = 0;
    while (i < 5)
    {
      int j = 0;
      while (j < 12)
      {
        localArrayList.add(getLeftFootballBlockSingle(i));
        localArrayList.add(getRightFootballBlockSingle(j, i));
        j += 1;
      }
      i += 1;
    }
    return sysCopy(localArrayList);
  }
  
  public static byte[] demoBlackBlockNoPage()
  {
    return new byte[] { 123, 123, 124, 32, 32, 123, 123, 124, 32, 32, 123, 123, 124, 10, 125, 125, 126, 32, 32, 125, 125, 126, 32, 32, 125, 125, 126, 10 };
  }
  
  private static byte[] getLeftFootballBlockSingle(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    float f = 16.0F * (4.0F + DELTA_L_Y * paramInt);
    paramInt = (int)(f % 256.0F);
    int i = (int)(f / 256.0F);
    f = 8.0F * INIT_L_X;
    int j = (int)(f % 256.0F);
    int k = (int)(f / 256.0F);
    localArrayList.add(cmdSetX((byte)j, (byte)k));
    localArrayList.add(cmdSetY((byte)paramInt, (byte)i));
    localArrayList.add(cmdPrtFootballL());
    return sysCopy(localArrayList);
  }
  
  public static byte[] getRightFootballBlockSingle(float paramFloat1, float paramFloat2)
  {
    ArrayList localArrayList = new ArrayList();
    paramFloat1 = 8.0F * (INIT_S_X + 5.3F * paramFloat1);
    int i = (int)(paramFloat1 % 256.0F);
    int j = (int)(paramFloat1 / 256.0F);
    paramFloat1 = 16.0F * (6.3F + DELTA_S_Y * paramFloat2);
    int k = (int)(paramFloat1 % 256.0F);
    int m = (int)(paramFloat1 / 256.0F);
    localArrayList.add(cmdSetX((byte)i, (byte)j));
    localArrayList.add(cmdSetY((byte)k, (byte)m));
    localArrayList.add(cmdPrtFootballS());
    return sysCopy(localArrayList);
  }
  
  private static byte[] getRightFootballBottomBlockSingle(float paramFloat1, float paramFloat2)
  {
    ArrayList localArrayList = new ArrayList();
    paramFloat1 = 8.0F * (INIT_L_X + paramFloat1);
    int i = (int)(paramFloat1 % 256.0F);
    int j = (int)(paramFloat1 / 256.0F);
    paramFloat1 = 16.0F * paramFloat2;
    int k = (int)(paramFloat1 % 256.0F);
    int m = (int)(paramFloat1 / 256.0F);
    localArrayList.add(cmdSetX((byte)i, (byte)j));
    localArrayList.add(cmdSetY((byte)k, (byte)m));
    localArrayList.add(cmdPrtFootballXL());
    return sysCopy(localArrayList);
  }
  
  public static byte[] getWelfareBlockSingle(float paramFloat1, float paramFloat2)
  {
    ArrayList localArrayList = new ArrayList();
    paramFloat1 = 8.0F * (WF_INIT_L_X + 4.69F * paramFloat1);
    int i = (int)(paramFloat1 % 256.0F);
    int j = (int)(paramFloat1 / 256.0F);
    paramFloat1 = 16.0F * (WF_INIT_LEFT_Y + WF_DELTA_L_Y * paramFloat2);
    int k = (int)(paramFloat1 % 256.0F);
    int m = (int)(paramFloat1 / 256.0F);
    localArrayList.add(cmdSetX((byte)i, (byte)j));
    localArrayList.add(cmdSetY((byte)k, (byte)m));
    localArrayList.add(cmdPrtWelfareBlock());
    return sysCopy(localArrayList);
  }
  
  private static byte[] getWelfareRightSquareSingle(float paramFloat1, float paramFloat2)
  {
    ArrayList localArrayList = new ArrayList();
    paramFloat1 = 8.0F * paramFloat1;
    int i = (int)(paramFloat1 % 256.0F);
    int j = (int)(paramFloat1 / 256.0F);
    paramFloat1 = 16.0F * paramFloat2;
    int k = (int)(paramFloat1 % 256.0F);
    int m = (int)(paramFloat1 / 256.0F);
    localArrayList.add(cmdSetX((byte)i, (byte)j));
    localArrayList.add(cmdSetY((byte)k, (byte)m));
    localArrayList.add(cmdPrtWelfareSquare());
    return sysCopy(localArrayList);
  }
  
  private static byte getYnh(double paramDouble)
  {
    return (byte)(int)((float)(16.0D * paramDouble) / 256.0F);
  }
  
  private static byte getYnl(double paramDouble)
  {
    return (byte)(int)((float)(16.0D * paramDouble) % 256.0F);
  }
  
  private static byte[] leftAllBlackBlock(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(cmdInitPageModelSetXY());
    if (paramInt <= 0) {
      return null;
    }
    int i = 0;
    while (i < paramInt)
    {
      localArrayList.add(getLeftFootballBlockSingle(i));
      i += 1;
    }
    return sysCopy(localArrayList);
  }
  
  public static byte[] prtPageFootball3(PrtLotteryBean paramPrtLotteryBean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(cmdDefFootballBlockXL());
    localArrayList.add(cmdDefFootballBlock());
    localArrayList.add(cmdUserDefChoose());
    localArrayList.add(cmdPrintModeChoose(1));
    localArrayList.add(cmdSetPageSize((byte)Byte.MIN_VALUE, (byte)2, (byte)-32, (byte)11));
    localArrayList.add(cmdInitPageData());
    localArrayList.add(leftAllBlackBlock(31));
    localArrayList.add(paramPrtLotteryBean.getLotteryData());
    localArrayList.add(getRightFootballBottomBlockSingle(72.8F, RIGHT_BOTTOM_Y));
    localArrayList.add(cmdNewLine());
    localArrayList.add(cmdNewLine());
    localArrayList.add(cmdStartPrintPage());
    localArrayList.add(cmdPrintModeChoose(0));
    localArrayList.add(cmdUserDefCancel());
    localArrayList.add(cmdCutPaper());
    return sysCopy(localArrayList);
  }
  
  public static byte[] prtPageFootball8(PrtLotteryBean paramPrtLotteryBean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(cmdDefFootballBlockXL());
    localArrayList.add(cmdDefFootballBlock());
    localArrayList.add(cmdUserDefChoose());
    localArrayList.add(cmdPrintModeChoose(1));
    localArrayList.add(cmdSetPageSize((byte)Byte.MIN_VALUE, (byte)2, (byte)90, (byte)12));
    localArrayList.add(cmdInitPageData());
    localArrayList.add(leftAllBlackBlock(36));
    localArrayList.add(paramPrtLotteryBean.getLotteryData());
    localArrayList.add(getRightFootballBottomBlockSingle(72.8F, RIGHT_BOTTOM_Y));
    localArrayList.add(cmdNewLine());
    localArrayList.add(cmdNewLine());
    localArrayList.add(cmdStartPrintPage());
    localArrayList.add(cmdPrintModeChoose(0));
    localArrayList.add(cmdUserDefCancel());
    localArrayList.add(cmdCutPaper());
    return sysCopy(localArrayList);
  }
  
  public static byte[] prtPageFootballDemo8()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(cmdDefFootballBlockXL());
    localArrayList.add(cmdDefFootballBlock());
    localArrayList.add(cmdUserDefChoose());
    localArrayList.add(cmdPrtFootballXL());
    localArrayList.add(cmdNewLine());
    localArrayList.add(cmdPrtFootballL());
    localArrayList.add(cmdNewLine());
    localArrayList.add(cmdPrtFootballS());
    localArrayList.add(cmdNewLine());
    localArrayList.add(cmdUserDefChoose());
    localArrayList.add(cmdPrintModeChoose(1));
    localArrayList.add(cmdSetPageSize((byte)Byte.MIN_VALUE, (byte)2, (byte)-32, (byte)2));
    localArrayList.add(cmdInitPageData());
    localArrayList.add(demoBlackBlock());
    localArrayList.add(cmdStartPrintPage());
    localArrayList.add(cmdPrintModeChoose(0));
    localArrayList.add(cmdUserDefCancel());
    return sysCopy(localArrayList);
  }
  
  public static byte[] prtPageFootballSuperLotto(PrtLotteryBean paramPrtLotteryBean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(cmdDefFootballBlockXL());
    localArrayList.add(cmdDefFootballBlock());
    localArrayList.add(cmdUserDefChoose());
    localArrayList.add(cmdPrintModeChoose(1));
    localArrayList.add(cmdSetPageSize((byte)Byte.MIN_VALUE, (byte)2, (byte)90, (byte)12));
    localArrayList.add(cmdInitPageData());
    localArrayList.add(leftAllBlackBlock(33));
    localArrayList.add(paramPrtLotteryBean.getLotteryData());
    localArrayList.add(getRightFootballBottomBlockSingle(72.8F, RIGHT_BOTTOM_Y));
    localArrayList.add(cmdNewLine());
    localArrayList.add(cmdNewLine());
    localArrayList.add(cmdStartPrintPage());
    localArrayList.add(cmdPrintModeChoose(0));
    localArrayList.add(cmdUserDefCancel());
    localArrayList.add(cmdCutPaper());
    return sysCopy(localArrayList);
  }
  
  public static byte[] prtPageFootballWinLossGame(PrtLotteryBean paramPrtLotteryBean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(cmdDefFootballBlockXL());
    localArrayList.add(cmdDefFootballBlock());
    localArrayList.add(cmdUserDefChoose());
    localArrayList.add(cmdPrintModeChoose(1));
    double d = RIGHT_BOTTOM_Y + DELTA_L_Y * 4.0F;
    localArrayList.add(cmdSetPageSize((byte)Byte.MIN_VALUE, (byte)2, getYnl(d), getYnh(d)));
    localArrayList.add(cmdInitPageData());
    localArrayList.add(leftAllBlackBlock(19));
    localArrayList.add(paramPrtLotteryBean.getLotteryData());
    localArrayList.add(getRightFootballBottomBlockSingle(72.8F, RIGHT_BOTTOM_Y));
    localArrayList.add(cmdStartPrintPage());
    localArrayList.add(cmdCutPaper30());
    localArrayList.add(cmdPrintModeChoose(0));
    localArrayList.add(cmdUserDefCancel());
    return sysCopy(localArrayList);
  }
  
  public static byte[] prtPageWelfare3D(PrtLotteryBean paramPrtLotteryBean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(cmdCutPaper30());
    localArrayList.add(cmdDefWelfareBlock());
    localArrayList.add(cmdUserDefChoose());
    localArrayList.add(cmdPrintModeChoose(1));
    double d1 = 0.0F + WF_DELTA_L_Y * 2.0F + 1.75D;
    localArrayList.add(cmdSetPageSize((byte)Byte.MIN_VALUE, (byte)2, getYnl(d1), getYnh(d1)));
    localArrayList.add(cmdInitPageData());
    localArrayList.add(cmdInitPageModelSetXY());
    localArrayList.add(paramPrtLotteryBean.getLotteryDataWelfareHead());
    localArrayList.add(getWelfareRightSquareSingle(WF_INIT_RIGHT_X, 3.296F));
    localArrayList.add(cmdStartPrintPage());
    localArrayList.add(cmdCutPaper30());
    localArrayList.add(cmdUserDefChoose());
    localArrayList.add(cmdPrintModeChoose(1));
    double d2 = WF_RIGHT_BOTTOM_Y + 5.625F + -d1;
    localArrayList.add(cmdSetPageSize((byte)Byte.MIN_VALUE, (byte)2, getYnl(d2), getYnh(d2)));
    localArrayList.add(cmdInitPageData());
    localArrayList.add(cmdInitPageModelSetXY());
    localArrayList.add(paramPrtLotteryBean.getLotteryData());
    localArrayList.add(getWelfareRightSquareSingle(WF_INIT_RIGHT_X, WF_RIGHT_BOTTOM_Y - (float)d1));
    localArrayList.add(cmdStartPrintPage());
    double d3 = (WF_DELTA_L_Y - 1.875F) * 0.3D + d1 + 0.75D;
    localArrayList.add(cmdPrintModeChoose(1));
    localArrayList.add(cmdSetPageSize((byte)Byte.MIN_VALUE, (byte)2, getYnl(d3), getYnh(d3)));
    localArrayList.add(cmdInitPageData());
    localArrayList.add(cmdStartPrintPage());
    localArrayList.add(cmdCutPaper30());
    localArrayList.add(cmdPrintModeChoose(0));
    localArrayList.add(cmdUserDefCancel());
    Log.e("", "3D yPage1:" + d1 + "  yPage2" + d2 + "   yPage3" + d3);
    return sysCopy(localArrayList);
  }
  
  public static byte[] prtPageWelfare3D_Alpha(PrtLotteryBean paramPrtLotteryBean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(cmdCutPaper());
    localArrayList.add(cmdDefWelfareBlock());
    localArrayList.add(cmdUserDefChoose());
    localArrayList.add(cmdPrintModeChoose(1));
    localArrayList.add(cmdSetPageSize((byte)Byte.MIN_VALUE, (byte)2, (byte)0, (byte)11));
    localArrayList.add(cmdInitPageData());
    localArrayList.add(cmdInitPageModelSetXY());
    localArrayList.add(paramPrtLotteryBean.getLotteryData());
    localArrayList.add(getWelfareRightSquareSingle(WF_INIT_RIGHT_X, 3.146F));
    localArrayList.add(getWelfareRightSquareSingle(WF_INIT_RIGHT_X, WF_RIGHT_BOTTOM_Y));
    localArrayList.add(cmdStartPrintPage());
    localArrayList.add(cmdPrintModeChoose(0));
    localArrayList.add(cmdUserDefCancel());
    localArrayList.add(cmdCutPaper());
    return sysCopy(localArrayList);
  }
  
  public static byte[] prtPageWelfare7Le(PrtLotteryBean paramPrtLotteryBean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(cmdCutPaper30());
    localArrayList.add(cmdDefWelfareBlock());
    localArrayList.add(cmdUserDefChoose());
    localArrayList.add(cmdPrintModeChoose(1));
    double d1 = 0.0F + WF_DELTA_L_Y * 2.0F + 0.35F;
    localArrayList.add(cmdSetPageSize((byte)Byte.MIN_VALUE, (byte)2, getYnl(d1), getYnh(d1)));
    localArrayList.add(cmdInitPageData());
    localArrayList.add(cmdInitPageModelSetXY());
    localArrayList.add(paramPrtLotteryBean.getLotteryDataWelfareHead());
    localArrayList.add(getWelfareRightSquareSingle(WF_INIT_RIGHT_X, 3.846F));
    localArrayList.add(cmdStartPrintPage());
    localArrayList.add(cmdCutPaper30());
    localArrayList.add(cmdUserDefChoose());
    localArrayList.add(cmdPrintModeChoose(1));
    double d2 = WF_RIGHT_BOTTOM_Y + 5.625F - d1 + 0.6D;
    localArrayList.add(cmdSetPageSize((byte)Byte.MIN_VALUE, (byte)2, getYnl(d2), getYnh(d2)));
    localArrayList.add(cmdInitPageData());
    localArrayList.add(cmdInitPageModelSetXY());
    localArrayList.add(paramPrtLotteryBean.getLotteryData());
    localArrayList.add(getWelfareRightSquareSingle(WF_INIT_RIGHT_X, WF_RIGHT_BOTTOM_Y - (float)d1 + 0.6F));
    localArrayList.add(cmdStartPrintPage());
    double d3 = d1 - 0.6D + (WF_DELTA_L_Y - 1.875F);
    localArrayList.add(cmdPrintModeChoose(1));
    localArrayList.add(cmdSetPageSize((byte)Byte.MIN_VALUE, (byte)2, getYnl(d3), getYnh(d3)));
    localArrayList.add(cmdInitPageData());
    localArrayList.add(cmdStartPrintPage());
    localArrayList.add(cmdCutPaper30());
    localArrayList.add(cmdPrintModeChoose(0));
    localArrayList.add(cmdUserDefCancel());
    Log.e("", "7le yPage1:" + d1 + "  yPage2" + d2 + "   yPage3" + d3);
    return sysCopy(localArrayList);
  }
  
  public static byte[] prtPageWelfareDoubleBall(PrtLotteryBean paramPrtLotteryBean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(cmdCutPaper30());
    localArrayList.add(cmdDefWelfareBlock());
    localArrayList.add(cmdUserDefChoose());
    localArrayList.add(cmdPrintModeChoose(1));
    double d1 = 0.0F + WF_DELTA_L_Y * 2.0F;
    localArrayList.add(cmdSetPageSize((byte)Byte.MIN_VALUE, (byte)2, getYnl(d1), getYnh(d1)));
    localArrayList.add(cmdInitPageData());
    localArrayList.add(cmdInitPageModelSetXY());
    localArrayList.add(paramPrtLotteryBean.getLotteryDataWelfareHead());
    localArrayList.add(getWelfareRightSquareSingle(WF_INIT_RIGHT_X, 3.146F));
    localArrayList.add(cmdStartPrintPage());
    localArrayList.add(cmdCutPaper30());
    localArrayList.add(cmdUserDefChoose());
    localArrayList.add(cmdPrintModeChoose(1));
    double d2 = WF_RIGHT_BOTTOM_Y + 5.625F - d1;
    localArrayList.add(cmdSetPageSize((byte)Byte.MIN_VALUE, (byte)2, getYnl(d2), getYnh(d2)));
    localArrayList.add(cmdInitPageData());
    localArrayList.add(cmdInitPageModelSetXY());
    localArrayList.add(paramPrtLotteryBean.getLotteryData());
    localArrayList.add(getWelfareRightSquareSingle(WF_INIT_RIGHT_X, WF_RIGHT_BOTTOM_Y - (float)d1));
    localArrayList.add(cmdStartPrintPage());
    double d3 = WF_DELTA_L_Y - 1.875F + d1 + 0.75D;
    localArrayList.add(cmdPrintModeChoose(1));
    localArrayList.add(cmdSetPageSize((byte)Byte.MIN_VALUE, (byte)2, getYnl(d3), getYnh(d3)));
    localArrayList.add(cmdInitPageData());
    localArrayList.add(cmdStartPrintPage());
    localArrayList.add(cmdCutPaper30());
    localArrayList.add(cmdPrintModeChoose(0));
    localArrayList.add(cmdUserDefCancel());
    Log.e("", "双色 yPage1:" + d1 + "  yPage2" + d2 + "   yPage3" + d3);
    return sysCopy(localArrayList);
  }
  
  public static byte[] sysCopy(List<byte[]> paramList)
  {
    int i = 0;
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext()) {
      i += ((byte[])((Iterator)localObject).next()).length;
    }
    localObject = new byte[i];
    i = 0;
    Iterator<byte[]> iterator = paramList.iterator();
    while (iterator.hasNext())
    {
      byte[] arrayOfByte = iterator.next();
      System.arraycopy(arrayOfByte, 0, localObject, i, arrayOfByte.length);
      i += arrayOfByte.length;
    }
    return (byte[])localObject;
  }
}
