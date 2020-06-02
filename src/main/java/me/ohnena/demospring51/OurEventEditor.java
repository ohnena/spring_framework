package me.ohnena.demospring51;

import java.beans.PropertyEditorSupport;

//@Component <<<-----절대로 빈으로 등록해서 사용하면 안된다. 아래와 같이 내부적으로 Value로 관리해버리기때문에 stateful >> 고로 Thread-safe하지 않다.
public class OurEventEditor extends PropertyEditorSupport {     //오늘의 주인공...PropertyEditor..
    @Override
    public String getAsText() {
//        return super.getAsText();
        OurEvent event = (OurEvent) getValue();
        return event.getId().toString();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
//        super.setAsText(text);
        setValue(new OurEvent(Integer.parseInt(text)));
    }
}
