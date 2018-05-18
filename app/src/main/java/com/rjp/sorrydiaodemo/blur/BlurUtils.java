package com.rjp.sorrydiaodemo.blur;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.renderscript.Type;

/**
 * author : Gimpo create on 2018/5/18 18:21
 * email  : jimbo922@163.com
 */
public class BlurUtils {

    public static Bitmap blurBitmap(Bitmap bitmap, float radius, Context context) {
        //Create renderscript
        RenderScript rs = RenderScript.create(context);

        //Create allocation from Bitmap
        Allocation allocation = Allocation.createFromBitmap(rs, bitmap);

        Type t = allocation.getType();

        //Create allocation with the same type
        Allocation blurredAllocation = Allocation.createTyped(rs, t);

        //Create script
        ScriptIntrinsicBlur blurScript = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
        //Set blur radius (maximum 25.0)
        blurScript.setRadius(radius);
        //Set input for script
        blurScript.setInput(allocation);
        //Call script for output allocation
        blurScript.forEach(blurredAllocation);

        //Copy script result into bitmap
        blurredAllocation.copyTo(bitmap);

        //Destroy everything to free memory
        allocation.destroy();
        blurredAllocation.destroy();
        blurScript.destroy();
//        t.destroy();
        rs.destroy();
        return bitmap;
    }
}
