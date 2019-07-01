package com.hemika.service;

import com.hemika.model.patientData.ComingExamineData;
import com.hemika.model.patientData.PatientData;
import com.hemika.model.patientData.PatientProfileVTO;
import com.hemika.model.patientData.TreatmentData;
import com.hemika.repository.PatientDataRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientDataSer {

    private PatientDataRep dataRep;

    @Autowired
    public PatientDataSer(PatientDataRep dataRep) {
        this.dataRep = dataRep;
    }

    public PatientProfileVTO getPatient(String nationalId){

        PatientData patientData = this.dataRep.getPatientData(nationalId);
        ComingExamineData comingExamineData = this.dataRep.getComingExamineData(nationalId);
        List<TreatmentData> treatmentData = this.dataRep.getTreatmentData(nationalId);

        PatientProfileVTO patientProfileVTO = new PatientProfileVTO();

        patientProfileVTO.setPatientData(patientData);
        patientProfileVTO.setComingExamineData(comingExamineData);
        patientProfileVTO.setTreatmentData(treatmentData);

        return patientProfileVTO;
    }
}
