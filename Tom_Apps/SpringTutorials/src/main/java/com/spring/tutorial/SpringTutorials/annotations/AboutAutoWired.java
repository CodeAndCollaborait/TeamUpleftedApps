package com.spring.tutorial.SpringTutorials.annotations;


public class AboutAutoWired {
    private String className;
    private String objName;


    public AboutAutoWired(String className, String objName) {
        this.className = className;
        this.objName = objName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    @Override
    public String toString() {
        return "AboutAutoWired{" +
                "className='" + className + '\'' +
                ", objName='" + objName + '\'' +
                '}';
    }
}
