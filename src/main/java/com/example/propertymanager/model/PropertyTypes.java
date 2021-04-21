package com.example.propertymanager.model;

public enum PropertyTypes {

    FLAT(1), BUNGLOW(2), VILLA(3);
    
    Integer id;
    PropertyTypes(int id){
        this.id = id;
    }
    
    Integer getId(){
        return id;
    }
    
    public static Boolean exists(Integer id) {
        for (PropertyTypes propertyType : PropertyTypes.values()) {
            if (propertyType.getId().compareTo(id) == 0)
                return true;
        }
        return false;
    }
}
