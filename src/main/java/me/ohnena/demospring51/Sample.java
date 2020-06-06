package me.ohnena.demospring51;

import org.springframework.stereotype.Component;

@Component
public class Sample {
    private int data = 100;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
