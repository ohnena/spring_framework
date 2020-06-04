package me.ohnena.demospring51;

import java.beans.PropertyEditorSupport;

//절대로 빈으로 등록해서 사용하면 안된다. 아래와 같이 내부적으로 Value로 관리해버리기때문에 stateful >> 고로 Thread-safe하지 않다.
public class OurEventEditor extends PropertyEditorSupport {     //오늘의 주인공...PropertyEditor..
    //
    // 주의!) 아래 내용을 오버라이드만 해도, PropertyEditor를 통한 데이터바인딩이 작동해버리더라...
    //      이유는 모르겠다.
    //      어쨌든 그래서, 컨버터/포매터 테스트를 위해 주석처리를 한다.
    //

//    @Override
//    public String getAsText() {
//        System.out.println("PropertyEditor.getAsText() is working...");
//        OurEvent event = (OurEvent) getValue();
//        return event.getId().toString();
//    }
//
//    @Override
//    public void setAsText(String text) throws IllegalArgumentException {
//        System.out.println("PropertyEditor.setAsText() is working...");
//        setValue(new OurEvent(Integer.parseInt(text)));
//    }
}
