package com.hemika.model.patientData;

import java.util.Arrays;
import java.util.List;

public class PatientProfileVTO {
    private PatientData patientData;
    private ComingExamineData comingExamineData;
    private List<TreatmentData> treatmentData;

    public PatientProfileVTO() {
    }

    public PatientData getPatientData() {
        return patientData;
    }

    public void setPatientData(PatientData patientData) {
        this.patientData = patientData;
    }

    public ComingExamineData getComingExamineData() {
        return comingExamineData;
    }

    public void setComingExamineData(ComingExamineData comingExamineData) {
        this.comingExamineData = comingExamineData;
    }

    public List<TreatmentData> getTreatmentData() {
        return treatmentData;
    }

    public void setTreatmentData(List<TreatmentData> treatmentData) {
        this.treatmentData = treatmentData;
    }

    @Override
    public String toString() {
        return "PatientProfileVTO{" +
                "patientData=" + patientData +
                ", comingExamineData=" + comingExamineData +
                ", treatmentData=" + treatmentData +
                '}';
    }
}


