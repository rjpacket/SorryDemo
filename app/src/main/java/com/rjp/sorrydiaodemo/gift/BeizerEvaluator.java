package com.rjp.sorrydiaodemo.gift;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

public class BeizerEvaluator implements TypeEvaluator<PointF> {
  
        private PointF point1;  
        private PointF point2;  
  
        private PointF pointF;  
  
        public BeizerEvaluator(PointF point1, PointF point2) {  
            this.point1 = point1;  
            this.point2 = point2;  
        }  
  
        @Override  
        public PointF evaluate(float time, PointF start, PointF end) {  
            float timeLeft = 1.0f - time;  
            pointF = new PointF();//结果  
  
            PointF point0 = start;//起点  
  
            PointF point3 = end;//终点  
            pointF.x = timeLeft * timeLeft * timeLeft * (point0.x)  
                    + 3 * timeLeft * timeLeft * time * (point1.x)  
                    + 3 * timeLeft * time * time * (point2.x)  
                    + time * time * time * (point3.x);  
  
            pointF.y = timeLeft * timeLeft * timeLeft * (point0.y)  
                    + 3 * timeLeft * timeLeft * time * (point1.y)  
                    + 3 * timeLeft * time * time * (point2.y)  
                    + time * time * time * (point3.y);  
            return pointF;  
        }  
    } 