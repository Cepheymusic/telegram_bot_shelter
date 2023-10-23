package dev.pro.shelter.constant;

public enum Keyboard {

    START("/start"),
    INFO_SHELTER("info_shelter_"),
    WORK_TIME_AND_ADDRESS("work_time_and_address_"),
    SHELTER_RULES("shelter_rules_"),
    SECURITY_CONTACTS("security_contacts_"),
    SAFETY_PRECAUTIONS("safety_precautions_"),
    LEAVE_REQUEST("leave_request_"),
    CALL_VOLUNTEER("call_volunteer_");

    private final String id;

    Keyboard(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }
}