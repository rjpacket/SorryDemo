package com.rjp.sorrydiaodemo.bluetooth;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.rjp.sorrydiaodemo.R;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FootballLottery3Activity extends AppCompatActivity {
    @BindView(R.id.btn_lottery_demo)
    Button btnLotteryDemo;
    @BindView(R.id.btn_prt_lottery)
    Button btnPrtLottery;
    @BindView(R.id.cb_0_0)
    CheckBox cb00;
    @BindView(R.id.cb_0_1)
    CheckBox cb01;
    @BindView(R.id.cb_0_10)
    CheckBox cb010;
    @BindView(R.id.cb_0_11)
    CheckBox cb011;
    @BindView(R.id.cb_0_12)
    CheckBox cb012;
    @BindView(R.id.cb_0_13)
    CheckBox cb013;
    @BindView(R.id.cb_0_14)
    CheckBox cb014;
    @BindView(R.id.cb_0_15)
    CheckBox cb015;
    @BindView(R.id.cb_0_16)
    CheckBox cb016;
    @BindView(R.id.cb_0_17)
    CheckBox cb017;
    @BindView(R.id.cb_0_18)
    CheckBox cb018;
    @BindView(R.id.cb_0_19)
    CheckBox cb019;
    @BindView(R.id.cb_0_20)
    CheckBox cb020;
    @BindView(R.id.cb_0_21)
    CheckBox cb021;
    @BindView(R.id.cb_0_22)
    CheckBox cb022;
    @BindView(R.id.cb_0_23)
    CheckBox cb023;
    @BindView(R.id.cb_0_24)
    CheckBox cb024;
    @BindView(R.id.cb_0_26)
    CheckBox cb026;
    @BindView(R.id.cb_0_4)
    CheckBox cb04;
    @BindView(R.id.cb_0_5)
    CheckBox cb05;
    @BindView(R.id.cb_0_6)
    CheckBox cb06;
    @BindView(R.id.cb_0_7)
    CheckBox cb07;
    @BindView(R.id.cb_0_8)
    CheckBox cb08;
    @BindView(R.id.cb_1_0)
    CheckBox cb10;
    @BindView(R.id.cb_10_0)
    CheckBox cb100;
    @BindView(R.id.cb_10_1)
    CheckBox cb101;
    @BindView(R.id.cb_10_10)
    CheckBox cb1010;
    @BindView(R.id.cb_10_11)
    CheckBox cb1011;
    @BindView(R.id.cb_10_12)
    CheckBox cb1012;
    @BindView(R.id.cb_10_13)
    CheckBox cb1013;
    @BindView(R.id.cb_10_14)
    CheckBox cb1014;
    @BindView(R.id.cb_10_15)
    CheckBox cb1015;
    @BindView(R.id.cb_10_16)
    CheckBox cb1016;
    @BindView(R.id.cb_10_17)
    CheckBox cb1017;
    @BindView(R.id.cb_10_18)
    CheckBox cb1018;
    @BindView(R.id.cb_10_20)
    CheckBox cb1020;
    @BindView(R.id.cb_10_21)
    CheckBox cb1021;
    @BindView(R.id.cb_10_22)
    CheckBox cb1022;
    @BindView(R.id.cb_10_23)
    CheckBox cb1023;
    @BindView(R.id.cb_10_24)
    CheckBox cb1024;
    @BindView(R.id.cb_10_26)
    CheckBox cb1026;
    @BindView(R.id.cb_10_27)
    CheckBox cb1027;
    @BindView(R.id.cb_10_28)
    CheckBox cb1028;
    @BindView(R.id.cb_10_4)
    CheckBox cb104;
    @BindView(R.id.cb_10_5)
    CheckBox cb105;
    @BindView(R.id.cb_10_6)
    CheckBox cb106;
    @BindView(R.id.cb_10_7)
    CheckBox cb107;
    @BindView(R.id.cb_10_8)
    CheckBox cb108;
    @BindView(R.id.cb_1_1)
    CheckBox cb11;
    @BindView(R.id.cb_1_10)
    CheckBox cb110;
    @BindView(R.id.cb_1_11)
    CheckBox cb111;
    @BindView(R.id.cb_11_11)
    CheckBox cb1111;
    @BindView(R.id.cb_11_12)
    CheckBox cb1112;
    @BindView(R.id.cb_11_13)
    CheckBox cb1113;
    @BindView(R.id.cb_11_14)
    CheckBox cb1114;
    @BindView(R.id.cb_11_15)
    CheckBox cb1115;
    @BindView(R.id.cb_11_16)
    CheckBox cb1116;
    @BindView(R.id.cb_11_17)
    CheckBox cb1117;
    @BindView(R.id.cb_11_18)
    CheckBox cb1118;
    @BindView(R.id.cb_11_19)
    CheckBox cb1119;
    @BindView(R.id.cb_1_12)
    CheckBox cb112;
    @BindView(R.id.cb_11_23)
    CheckBox cb1123;
    @BindView(R.id.cb_11_24)
    CheckBox cb1124;
    @BindView(R.id.cb_11_26)
    CheckBox cb1126;
    @BindView(R.id.cb_11_27)
    CheckBox cb1127;
    @BindView(R.id.cb_11_28)
    CheckBox cb1128;
    @BindView(R.id.cb_1_13)
    CheckBox cb113;
    @BindView(R.id.cb_1_14)
    CheckBox cb114;
    @BindView(R.id.cb_1_15)
    CheckBox cb115;
    @BindView(R.id.cb_1_16)
    CheckBox cb116;
    @BindView(R.id.cb_1_17)
    CheckBox cb117;
    @BindView(R.id.cb_1_18)
    CheckBox cb118;
    @BindView(R.id.cb_1_19)
    CheckBox cb119;
    @BindView(R.id.cb_11_0)
    CheckBox cb11_0;
    @BindView(R.id.cb_11_1)
    CheckBox cb11_1;
    @BindView(R.id.cb_11_4)
    CheckBox cb11_4;
    @BindView(R.id.cb_11_5)
    CheckBox cb11_5;
    @BindView(R.id.cb_11_6)
    CheckBox cb11_6;
    @BindView(R.id.cb_11_7)
    CheckBox cb11_7;
    @BindView(R.id.cb_11_8)
    CheckBox cb11_8;
    @BindView(R.id.cb_1_20)
    CheckBox cb120;
    @BindView(R.id.cb_1_21)
    CheckBox cb121;
    @BindView(R.id.cb_1_22)
    CheckBox cb122;
    @BindView(R.id.cb_1_23)
    CheckBox cb123;
    @BindView(R.id.cb_1_24)
    CheckBox cb124;
    @BindView(R.id.cb_1_26)
    CheckBox cb126;
    @BindView(R.id.cb_12_0)
    CheckBox cb12_0;
    @BindView(R.id.cb_12_1)
    CheckBox cb12_1;
    @BindView(R.id.cb_1_4)
    CheckBox cb14;
    @BindView(R.id.cb_1_5)
    CheckBox cb15;
    @BindView(R.id.cb_1_6)
    CheckBox cb16;
    @BindView(R.id.cb_1_7)
    CheckBox cb17;
    @BindView(R.id.cb_1_8)
    CheckBox cb18;
    @BindView(R.id.cb_2_0)
    CheckBox cb20;
    @BindView(R.id.cb_2_1)
    CheckBox cb21;
    @BindView(R.id.cb_2_10)
    CheckBox cb210;
    @BindView(R.id.cb_2_11)
    CheckBox cb211;
    @BindView(R.id.cb_2_12)
    CheckBox cb212;
    @BindView(R.id.cb_2_13)
    CheckBox cb213;
    @BindView(R.id.cb_2_14)
    CheckBox cb214;
    @BindView(R.id.cb_2_15)
    CheckBox cb215;
    @BindView(R.id.cb_2_16)
    CheckBox cb216;
    @BindView(R.id.cb_2_17)
    CheckBox cb217;
    @BindView(R.id.cb_2_18)
    CheckBox cb218;
    @BindView(R.id.cb_2_20)
    CheckBox cb220;
    @BindView(R.id.cb_2_21)
    CheckBox cb221;
    @BindView(R.id.cb_2_22)
    CheckBox cb222;
    @BindView(R.id.cb_2_23)
    CheckBox cb223;
    @BindView(R.id.cb_2_24)
    CheckBox cb224;
    @BindView(R.id.cb_2_26)
    CheckBox cb226;
    @BindView(R.id.cb_2_4)
    CheckBox cb24;
    @BindView(R.id.cb_2_5)
    CheckBox cb25;
    @BindView(R.id.cb_2_6)
    CheckBox cb26;
    @BindView(R.id.cb_2_7)
    CheckBox cb27;
    @BindView(R.id.cb_2_8)
    CheckBox cb28;
    @BindView(R.id.cb_3_0)
    CheckBox cb30;
    @BindView(R.id.cb_3_1)
    CheckBox cb31;
    @BindView(R.id.cb_3_11)
    CheckBox cb311;
    @BindView(R.id.cb_3_12)
    CheckBox cb312;
    @BindView(R.id.cb_3_13)
    CheckBox cb313;
    @BindView(R.id.cb_3_14)
    CheckBox cb314;
    @BindView(R.id.cb_3_15)
    CheckBox cb315;
    @BindView(R.id.cb_3_16)
    CheckBox cb316;
    @BindView(R.id.cb_3_17)
    CheckBox cb317;
    @BindView(R.id.cb_3_18)
    CheckBox cb318;
    @BindView(R.id.cb_3_19)
    CheckBox cb319;
    @BindView(R.id.cb_3_2)
    CheckBox cb32;
    @BindView(R.id.cb_3_23)
    CheckBox cb323;
    @BindView(R.id.cb_3_24)
    CheckBox cb324;
    @BindView(R.id.cb_3_26)
    CheckBox cb326;
    @BindView(R.id.cb_3_4)
    CheckBox cb34;
    @BindView(R.id.cb_3_5)
    CheckBox cb35;
    @BindView(R.id.cb_3_6)
    CheckBox cb36;
    @BindView(R.id.cb_3_7)
    CheckBox cb37;
    @BindView(R.id.cb_3_8)
    CheckBox cb38;
    @BindView(R.id.cb_4_0)
    CheckBox cb40;
    @BindView(R.id.cb_4_1)
    CheckBox cb41;
    @BindView(R.id.cb_4_10)
    CheckBox cb410;
    @BindView(R.id.cb_4_11)
    CheckBox cb411;
    @BindView(R.id.cb_4_12)
    CheckBox cb412;
    @BindView(R.id.cb_4_13)
    CheckBox cb413;
    @BindView(R.id.cb_4_14)
    CheckBox cb414;
    @BindView(R.id.cb_4_15)
    CheckBox cb415;
    @BindView(R.id.cb_4_16)
    CheckBox cb416;
    @BindView(R.id.cb_4_17)
    CheckBox cb417;
    @BindView(R.id.cb_4_18)
    CheckBox cb418;
    @BindView(R.id.cb_4_19)
    CheckBox cb419;
    @BindView(R.id.cb_4_20)
    CheckBox cb420;
    @BindView(R.id.cb_4_21)
    CheckBox cb421;
    @BindView(R.id.cb_4_22)
    CheckBox cb422;
    @BindView(R.id.cb_4_23)
    CheckBox cb423;
    @BindView(R.id.cb_4_24)
    CheckBox cb424;
    @BindView(R.id.cb_4_4)
    CheckBox cb44;
    @BindView(R.id.cb_4_5)
    CheckBox cb45;
    @BindView(R.id.cb_4_6)
    CheckBox cb46;
    @BindView(R.id.cb_4_7)
    CheckBox cb47;
    @BindView(R.id.cb_4_8)
    CheckBox cb48;
    @BindView(R.id.cb_5_0)
    CheckBox cb50;
    @BindView(R.id.cb_5_1)
    CheckBox cb51;
    @BindView(R.id.cb_5_10)
    CheckBox cb510;
    @BindView(R.id.cb_5_11)
    CheckBox cb511;
    @BindView(R.id.cb_5_12)
    CheckBox cb512;
    @BindView(R.id.cb_5_13)
    CheckBox cb513;
    @BindView(R.id.cb_5_14)
    CheckBox cb514;
    @BindView(R.id.cb_5_15)
    CheckBox cb515;
    @BindView(R.id.cb_5_16)
    CheckBox cb516;
    @BindView(R.id.cb_5_17)
    CheckBox cb517;
    @BindView(R.id.cb_5_18)
    CheckBox cb518;
    @BindView(R.id.cb_5_19)
    CheckBox cb519;
    @BindView(R.id.cb_5_2)
    CheckBox cb52;
    @BindView(R.id.cb_5_20)
    CheckBox cb520;
    @BindView(R.id.cb_5_21)
    CheckBox cb521;
    @BindView(R.id.cb_5_22)
    CheckBox cb522;
    @BindView(R.id.cb_5_23)
    CheckBox cb523;
    @BindView(R.id.cb_5_24)
    CheckBox cb524;
    @BindView(R.id.cb_5_4)
    CheckBox cb54;
    @BindView(R.id.cb_5_5)
    CheckBox cb55;
    @BindView(R.id.cb_5_6)
    CheckBox cb56;
    @BindView(R.id.cb_5_7)
    CheckBox cb57;
    @BindView(R.id.cb_5_8)
    CheckBox cb58;
    @BindView(R.id.cb_6_0)
    CheckBox cb60;
    @BindView(R.id.cb_6_1)
    CheckBox cb61;
    @BindView(R.id.cb_6_10)
    CheckBox cb610;
    @BindView(R.id.cb_6_11)
    CheckBox cb611;
    @BindView(R.id.cb_6_12)
    CheckBox cb612;
    @BindView(R.id.cb_6_13)
    CheckBox cb613;
    @BindView(R.id.cb_6_14)
    CheckBox cb614;
    @BindView(R.id.cb_6_15)
    CheckBox cb615;
    @BindView(R.id.cb_6_16)
    CheckBox cb616;
    @BindView(R.id.cb_6_17)
    CheckBox cb617;
    @BindView(R.id.cb_6_18)
    CheckBox cb618;
    @BindView(R.id.cb_6_20)
    CheckBox cb620;
    @BindView(R.id.cb_6_21)
    CheckBox cb621;
    @BindView(R.id.cb_6_22)
    CheckBox cb622;
    @BindView(R.id.cb_6_23)
    CheckBox cb623;
    @BindView(R.id.cb_6_24)
    CheckBox cb624;
    @BindView(R.id.cb_6_4)
    CheckBox cb64;
    @BindView(R.id.cb_6_5)
    CheckBox cb65;
    @BindView(R.id.cb_6_6)
    CheckBox cb66;
    @BindView(R.id.cb_6_7)
    CheckBox cb67;
    @BindView(R.id.cb_6_8)
    CheckBox cb68;
    @BindView(R.id.cb_7_0)
    CheckBox cb70;
    @BindView(R.id.cb_7_1)
    CheckBox cb71;
    @BindView(R.id.cb_7_11)
    CheckBox cb711;
    @BindView(R.id.cb_7_12)
    CheckBox cb712;
    @BindView(R.id.cb_7_13)
    CheckBox cb713;
    @BindView(R.id.cb_7_14)
    CheckBox cb714;
    @BindView(R.id.cb_7_15)
    CheckBox cb715;
    @BindView(R.id.cb_7_16)
    CheckBox cb716;
    @BindView(R.id.cb_7_17)
    CheckBox cb717;
    @BindView(R.id.cb_7_18)
    CheckBox cb718;
    @BindView(R.id.cb_7_19)
    CheckBox cb719;
    @BindView(R.id.cb_7_23)
    CheckBox cb723;
    @BindView(R.id.cb_7_24)
    CheckBox cb724;
    @BindView(R.id.cb_7_4)
    CheckBox cb74;
    @BindView(R.id.cb_7_5)
    CheckBox cb75;
    @BindView(R.id.cb_7_6)
    CheckBox cb76;
    @BindView(R.id.cb_7_7)
    CheckBox cb77;
    @BindView(R.id.cb_7_8)
    CheckBox cb78;
    @BindView(R.id.cb_8_0)
    CheckBox cb80;
    @BindView(R.id.cb_8_1)
    CheckBox cb81;
    @BindView(R.id.cb_8_10)
    CheckBox cb810;
    @BindView(R.id.cb_8_11)
    CheckBox cb811;
    @BindView(R.id.cb_8_12)
    CheckBox cb812;
    @BindView(R.id.cb_8_13)
    CheckBox cb813;
    @BindView(R.id.cb_8_14)
    CheckBox cb814;
    @BindView(R.id.cb_8_15)
    CheckBox cb815;
    @BindView(R.id.cb_8_16)
    CheckBox cb816;
    @BindView(R.id.cb_8_17)
    CheckBox cb817;
    @BindView(R.id.cb_8_18)
    CheckBox cb818;
    @BindView(R.id.cb_8_19)
    CheckBox cb819;
    @BindView(R.id.cb_8_2)
    CheckBox cb82;
    @BindView(R.id.cb_8_20)
    CheckBox cb820;
    @BindView(R.id.cb_8_21)
    CheckBox cb821;
    @BindView(R.id.cb_8_22)
    CheckBox cb822;
    @BindView(R.id.cb_8_23)
    CheckBox cb823;
    @BindView(R.id.cb_8_24)
    CheckBox cb824;
    @BindView(R.id.cb_8_26)
    CheckBox cb826;
    @BindView(R.id.cb_8_27)
    CheckBox cb827;
    @BindView(R.id.cb_8_28)
    CheckBox cb828;
    @BindView(R.id.cb_8_29)
    CheckBox cb829;
    @BindView(R.id.cb_8_4)
    CheckBox cb84;
    @BindView(R.id.cb_8_5)
    CheckBox cb85;
    @BindView(R.id.cb_8_6)
    CheckBox cb86;
    @BindView(R.id.cb_8_7)
    CheckBox cb87;
    @BindView(R.id.cb_8_8)
    CheckBox cb88;
    @BindView(R.id.cb_9_0)
    CheckBox cb90;
    @BindView(R.id.cb_9_1)
    CheckBox cb91;
    @BindView(R.id.cb_9_10)
    CheckBox cb910;
    @BindView(R.id.cb_9_11)
    CheckBox cb911;
    @BindView(R.id.cb_9_12)
    CheckBox cb912;
    @BindView(R.id.cb_9_13)
    CheckBox cb913;
    @BindView(R.id.cb_9_14)
    CheckBox cb914;
    @BindView(R.id.cb_9_15)
    CheckBox cb915;
    @BindView(R.id.cb_9_16)
    CheckBox cb916;
    @BindView(R.id.cb_9_17)
    CheckBox cb917;
    @BindView(R.id.cb_9_18)
    CheckBox cb918;
    @BindView(R.id.cb_9_19)
    CheckBox cb919;
    @BindView(R.id.cb_9_20)
    CheckBox cb920;
    @BindView(R.id.cb_9_21)
    CheckBox cb921;
    @BindView(R.id.cb_9_22)
    CheckBox cb922;
    @BindView(R.id.cb_9_23)
    CheckBox cb923;
    @BindView(R.id.cb_9_24)
    CheckBox cb924;
    @BindView(R.id.cb_9_26)
    CheckBox cb926;
    @BindView(R.id.cb_9_27)
    CheckBox cb927;
    @BindView(R.id.cb_9_28)
    CheckBox cb928;
    @BindView(R.id.cb_9_29)
    CheckBox cb929;
    @BindView(R.id.cb_9_4)
    CheckBox cb94;
    @BindView(R.id.cb_9_5)
    CheckBox cb95;
    @BindView(R.id.cb_9_6)
    CheckBox cb96;
    @BindView(R.id.cb_9_7)
    CheckBox cb97;
    @BindView(R.id.cb_9_8)
    CheckBox cb98;
    List<CheckBox> cbList;
    @BindView(R.id.et_lottery_height_space)
    EditText etLotteryHeightSpace;
    @BindView(R.id.et_lottery_margin_left)
    EditText etLotteryMarginLeft;
    @BindView(R.id.tv_lottery_height_space)
    TextView tvLotteryHeightSpace;
    private float MARGIN_LEFT;
    private float HEIGHT_SPACE;

    public void btnPriLotteryData() {
        String str = this.etLotteryMarginLeft.getText().toString();
        Object localObject = this.etLotteryHeightSpace.getText().toString();
        try {
            MARGIN_LEFT = Float.parseFloat(str);
            PLHelp.INIT_L_X = MARGIN_LEFT;
            PLHelp.INIT_S_X = PLHelp.INIT_L_X + 5.0F;
            try {
                float f3 = Float.parseFloat((String) localObject);
                HEIGHT_SPACE = f3;
                if (f3 == 0.0F) {
                    HEIGHT_SPACE = 4.038F;
                }
            } catch (Exception localException1) {
                for (; ; ) {
                    localException1.printStackTrace();
                    HEIGHT_SPACE = 4.038F;
                }
            }
            PLHelp.DELTA_L_Y = HEIGHT_SPACE + 1.1F;
            PLHelp.DELTA_S_Y = HEIGHT_SPACE + 1.1F;
            PLHelp.RIGHT_BOTTOM_Y = 4.0F + 30.0F * PLHelp.DELTA_L_Y + 2.2F;
            PLHelp.RIGHT_BOTTOM_X = PLHelp.INIT_S_X + 68.9F;
//            HPApplication.getAppInstance().setLocVal(HPApplication.PRT_LOTTERY_MARGIN_LEFT, f2 + "");
//            HPApplication.getAppInstance().setLocVal(HPApplication.PRT_LOTTERY_HEIGHT_SPACE, f1 + "");
            localObject = new PrtLotteryBean();
            ((PrtLotteryBean) localObject).setLotteryData(initCheckBoxCheck());
            ((PrtLotteryBean) localObject).setFlagLottery(1);
//            HPApplication.getAppInstance().btnPrtLotteryData((PrtLotteryBean) localObject);
            return;
        } catch (Exception localException2) {
            for (; ; ) {
                localException2.printStackTrace();
                float f2 = 0.0F;
            }
        }
    }

    public void demoLotteryCheck() {
        Iterator localIterator = this.cbList.iterator();
        while (localIterator.hasNext()) {
            ((CheckBox) localIterator.next()).setChecked(false);
        }
        this.cb00.setChecked(true);
        this.cb20.setChecked(true);
        this.cb40.setChecked(true);
        this.cb60.setChecked(true);
        this.cb80.setChecked(true);
        this.cb90.setChecked(true);
        this.cb100.setChecked(true);
        this.cb11_0.setChecked(true);
        this.cb31.setChecked(true);
        this.cb52.setChecked(true);
        this.cb14.setChecked(true);
        this.cb54.setChecked(true);
        this.cb94.setChecked(true);
        this.cb06.setChecked(true);
        this.cb46.setChecked(true);
        this.cb86.setChecked(true);
        this.cb96.setChecked(true);
        this.cb010.setChecked(true);
        this.cb410.setChecked(true);
        this.cb810.setChecked(true);
        this.cb113.setChecked(true);
        this.cb513.setChecked(true);
        this.cb913.setChecked(true);
        this.cb215.setChecked(true);
        this.cb715.setChecked(true);
        this.cb815.setChecked(true);
        this.cb1115.setChecked(true);
        this.cb019.setChecked(true);
        this.cb419.setChecked(true);
        this.cb819.setChecked(true);
        this.cb122.setChecked(true);
        this.cb522.setChecked(true);
        this.cb124.setChecked(true);
        this.cb324.setChecked(true);
        this.cb424.setChecked(true);
        this.cb524.setChecked(true);
        this.cb724.setChecked(true);
    }

    public byte[] initCheckBoxCheck() {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.cbList.iterator();
        while (localIterator.hasNext()) {
            Object localObject = (CheckBox) localIterator.next();
            if (((CheckBox) localObject).isChecked()) {
                String[] localObject1 = ((CheckBox) localObject).getTag().toString().split("_");
                int i = Integer.parseInt(localObject1[1]);
                int j = Integer.parseInt(localObject1[2]);
                localArrayList.add(PLHelp.getRightFootballBlockSingle(i, j));
            }
        }
        for (Object o : localArrayList) {
            Log.d("------->", o.toString());
        }
        return PLHelp.sysCopy(localArrayList);
    }

    public void initCheckBoxList() {
        this.cbList = new ArrayList();
        this.cbList.add(this.cb00);
        this.cbList.add(this.cb10);
        this.cbList.add(this.cb20);
        this.cbList.add(this.cb30);
        this.cbList.add(this.cb40);
        this.cbList.add(this.cb50);
        this.cbList.add(this.cb60);
        this.cbList.add(this.cb70);
        this.cbList.add(this.cb80);
        this.cbList.add(this.cb90);
        this.cbList.add(this.cb100);
        this.cbList.add(this.cb11_0);
        this.cbList.add(this.cb12_0);
        this.cbList.add(this.cb01);
        this.cbList.add(this.cb11);
        this.cbList.add(this.cb21);
        this.cbList.add(this.cb31);
        this.cbList.add(this.cb41);
        this.cbList.add(this.cb51);
        this.cbList.add(this.cb61);
        this.cbList.add(this.cb71);
        this.cbList.add(this.cb81);
        this.cbList.add(this.cb91);
        this.cbList.add(this.cb101);
        this.cbList.add(this.cb11_1);
        this.cbList.add(this.cb12_1);
        this.cbList.add(this.cb32);
        this.cbList.add(this.cb52);
        this.cbList.add(this.cb82);
        this.cbList.add(this.cb04);
        this.cbList.add(this.cb14);
        this.cbList.add(this.cb24);
        this.cbList.add(this.cb34);
        this.cbList.add(this.cb44);
        this.cbList.add(this.cb54);
        this.cbList.add(this.cb64);
        this.cbList.add(this.cb74);
        this.cbList.add(this.cb84);
        this.cbList.add(this.cb94);
        this.cbList.add(this.cb104);
        this.cbList.add(this.cb11_4);
        this.cbList.add(this.cb05);
        this.cbList.add(this.cb15);
        this.cbList.add(this.cb25);
        this.cbList.add(this.cb35);
        this.cbList.add(this.cb45);
        this.cbList.add(this.cb55);
        this.cbList.add(this.cb65);
        this.cbList.add(this.cb75);
        this.cbList.add(this.cb85);
        this.cbList.add(this.cb95);
        this.cbList.add(this.cb105);
        this.cbList.add(this.cb11_5);
        this.cbList.add(this.cb06);
        this.cbList.add(this.cb16);
        this.cbList.add(this.cb26);
        this.cbList.add(this.cb36);
        this.cbList.add(this.cb46);
        this.cbList.add(this.cb56);
        this.cbList.add(this.cb66);
        this.cbList.add(this.cb76);
        this.cbList.add(this.cb86);
        this.cbList.add(this.cb96);
        this.cbList.add(this.cb106);
        this.cbList.add(this.cb11_6);
        this.cbList.add(this.cb07);
        this.cbList.add(this.cb17);
        this.cbList.add(this.cb27);
        this.cbList.add(this.cb37);
        this.cbList.add(this.cb47);
        this.cbList.add(this.cb57);
        this.cbList.add(this.cb67);
        this.cbList.add(this.cb77);
        this.cbList.add(this.cb87);
        this.cbList.add(this.cb97);
        this.cbList.add(this.cb107);
        this.cbList.add(this.cb11_7);
        this.cbList.add(this.cb08);
        this.cbList.add(this.cb18);
        this.cbList.add(this.cb28);
        this.cbList.add(this.cb38);
        this.cbList.add(this.cb48);
        this.cbList.add(this.cb58);
        this.cbList.add(this.cb68);
        this.cbList.add(this.cb78);
        this.cbList.add(this.cb88);
        this.cbList.add(this.cb98);
        this.cbList.add(this.cb108);
        this.cbList.add(this.cb11_8);
        this.cbList.add(this.cb010);
        this.cbList.add(this.cb110);
        this.cbList.add(this.cb210);
        this.cbList.add(this.cb410);
        this.cbList.add(this.cb510);
        this.cbList.add(this.cb610);
        this.cbList.add(this.cb810);
        this.cbList.add(this.cb910);
        this.cbList.add(this.cb1010);
        this.cbList.add(this.cb011);
        this.cbList.add(this.cb111);
        this.cbList.add(this.cb211);
        this.cbList.add(this.cb311);
        this.cbList.add(this.cb411);
        this.cbList.add(this.cb511);
        this.cbList.add(this.cb611);
        this.cbList.add(this.cb711);
        this.cbList.add(this.cb811);
        this.cbList.add(this.cb911);
        this.cbList.add(this.cb1011);
        this.cbList.add(this.cb1111);
        this.cbList.add(this.cb012);
        this.cbList.add(this.cb112);
        this.cbList.add(this.cb212);
        this.cbList.add(this.cb312);
        this.cbList.add(this.cb412);
        this.cbList.add(this.cb512);
        this.cbList.add(this.cb612);
        this.cbList.add(this.cb712);
        this.cbList.add(this.cb812);
        this.cbList.add(this.cb912);
        this.cbList.add(this.cb1012);
        this.cbList.add(this.cb1112);
        this.cbList.add(this.cb013);
        this.cbList.add(this.cb113);
        this.cbList.add(this.cb213);
        this.cbList.add(this.cb313);
        this.cbList.add(this.cb413);
        this.cbList.add(this.cb513);
        this.cbList.add(this.cb613);
        this.cbList.add(this.cb713);
        this.cbList.add(this.cb813);
        this.cbList.add(this.cb913);
        this.cbList.add(this.cb1013);
        this.cbList.add(this.cb1113);
        this.cbList.add(this.cb014);
        this.cbList.add(this.cb114);
        this.cbList.add(this.cb214);
        this.cbList.add(this.cb314);
        this.cbList.add(this.cb414);
        this.cbList.add(this.cb514);
        this.cbList.add(this.cb614);
        this.cbList.add(this.cb714);
        this.cbList.add(this.cb814);
        this.cbList.add(this.cb914);
        this.cbList.add(this.cb1014);
        this.cbList.add(this.cb1114);
        this.cbList.add(this.cb015);
        this.cbList.add(this.cb115);
        this.cbList.add(this.cb215);
        this.cbList.add(this.cb315);
        this.cbList.add(this.cb415);
        this.cbList.add(this.cb515);
        this.cbList.add(this.cb615);
        this.cbList.add(this.cb715);
        this.cbList.add(this.cb815);
        this.cbList.add(this.cb915);
        this.cbList.add(this.cb1015);
        this.cbList.add(this.cb1115);
        this.cbList.add(this.cb016);
        this.cbList.add(this.cb116);
        this.cbList.add(this.cb216);
        this.cbList.add(this.cb316);
        this.cbList.add(this.cb416);
        this.cbList.add(this.cb516);
        this.cbList.add(this.cb616);
        this.cbList.add(this.cb716);
        this.cbList.add(this.cb816);
        this.cbList.add(this.cb916);
        this.cbList.add(this.cb1016);
        this.cbList.add(this.cb1116);
        this.cbList.add(this.cb017);
        this.cbList.add(this.cb117);
        this.cbList.add(this.cb217);
        this.cbList.add(this.cb317);
        this.cbList.add(this.cb417);
        this.cbList.add(this.cb517);
        this.cbList.add(this.cb617);
        this.cbList.add(this.cb717);
        this.cbList.add(this.cb817);
        this.cbList.add(this.cb917);
        this.cbList.add(this.cb1017);
        this.cbList.add(this.cb1117);
        this.cbList.add(this.cb018);
        this.cbList.add(this.cb118);
        this.cbList.add(this.cb218);
        this.cbList.add(this.cb318);
        this.cbList.add(this.cb418);
        this.cbList.add(this.cb518);
        this.cbList.add(this.cb618);
        this.cbList.add(this.cb718);
        this.cbList.add(this.cb818);
        this.cbList.add(this.cb918);
        this.cbList.add(this.cb1018);
        this.cbList.add(this.cb1118);
        this.cbList.add(this.cb019);
        this.cbList.add(this.cb119);
        this.cbList.add(this.cb319);
        this.cbList.add(this.cb419);
        this.cbList.add(this.cb519);
        this.cbList.add(this.cb719);
        this.cbList.add(this.cb819);
        this.cbList.add(this.cb919);
        this.cbList.add(this.cb1119);
        this.cbList.add(this.cb020);
        this.cbList.add(this.cb120);
        this.cbList.add(this.cb220);
        this.cbList.add(this.cb420);
        this.cbList.add(this.cb520);
        this.cbList.add(this.cb620);
        this.cbList.add(this.cb820);
        this.cbList.add(this.cb920);
        this.cbList.add(this.cb1020);
        this.cbList.add(this.cb021);
        this.cbList.add(this.cb121);
        this.cbList.add(this.cb221);
        this.cbList.add(this.cb421);
        this.cbList.add(this.cb521);
        this.cbList.add(this.cb621);
        this.cbList.add(this.cb821);
        this.cbList.add(this.cb921);
        this.cbList.add(this.cb1021);
        this.cbList.add(this.cb022);
        this.cbList.add(this.cb122);
        this.cbList.add(this.cb222);
        this.cbList.add(this.cb422);
        this.cbList.add(this.cb522);
        this.cbList.add(this.cb622);
        this.cbList.add(this.cb822);
        this.cbList.add(this.cb922);
        this.cbList.add(this.cb1022);
        this.cbList.add(this.cb023);
        this.cbList.add(this.cb123);
        this.cbList.add(this.cb223);
        this.cbList.add(this.cb323);
        this.cbList.add(this.cb423);
        this.cbList.add(this.cb523);
        this.cbList.add(this.cb623);
        this.cbList.add(this.cb723);
        this.cbList.add(this.cb823);
        this.cbList.add(this.cb923);
        this.cbList.add(this.cb1023);
        this.cbList.add(this.cb1123);
        this.cbList.add(this.cb024);
        this.cbList.add(this.cb124);
        this.cbList.add(this.cb224);
        this.cbList.add(this.cb324);
        this.cbList.add(this.cb424);
        this.cbList.add(this.cb524);
        this.cbList.add(this.cb624);
        this.cbList.add(this.cb724);
        this.cbList.add(this.cb824);
        this.cbList.add(this.cb924);
        this.cbList.add(this.cb1024);
        this.cbList.add(this.cb1124);
        this.cbList.add(this.cb026);
        this.cbList.add(this.cb126);
        this.cbList.add(this.cb226);
        this.cbList.add(this.cb326);
        this.cbList.add(this.cb826);
        this.cbList.add(this.cb926);
        this.cbList.add(this.cb1026);
        this.cbList.add(this.cb1126);
        this.cbList.add(this.cb827);
        this.cbList.add(this.cb927);
        this.cbList.add(this.cb1027);
        this.cbList.add(this.cb1127);
        this.cbList.add(this.cb828);
        this.cbList.add(this.cb928);
        this.cbList.add(this.cb1028);
        this.cbList.add(this.cb1128);
        this.cbList.add(this.cb829);
        this.cbList.add(this.cb929);
    }

    public void initDefaultLotteryCheck() {
        Iterator localIterator = this.cbList.iterator();
        while (localIterator.hasNext()) {
            ((CheckBox) localIterator.next()).setChecked(false);
        }
        this.cb00.setChecked(true);
        this.cb20.setChecked(true);
        this.cb40.setChecked(true);
        this.cb60.setChecked(true);
        this.cb80.setChecked(true);
        this.cb90.setChecked(true);
        this.cb100.setChecked(true);
        this.cb11_0.setChecked(true);
        this.cb31.setChecked(true);
    }

    public void initInputData() {
        float f;
        try {
            f = MARGIN_LEFT;
            this.etLotteryMarginLeft.setText(f + "");
        } catch (Exception localException1) {
            try {
                f = HEIGHT_SPACE;
                this.etLotteryHeightSpace.setText(f + "");
                return;
            } catch (Exception localException2) {
                for (; ; ) {
                    localException2.printStackTrace();
                    f = 4.038F;
                }
            }
        }
    }

    @OnClick({R.id.btn_lottery_demo, R.id.btn_prt_lottery})
    public void onClick(View paramView) {
        switch (paramView.getId()) {
            case R.id.btn_lottery_demo:
                demoLotteryCheck();
                return;
        }
        btnPriLotteryData();
    }

    protected void onCreate(@Nullable Bundle paramBundle) {
        super.onCreate(paramBundle);
        requestWindowFeature(1);
        setContentView(R.layout.activity_football_lottery_3);
        ButterKnife.bind(this);
        initCheckBoxList();
        initInputData();
    }
}
