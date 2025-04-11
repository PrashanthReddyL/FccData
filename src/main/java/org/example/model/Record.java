package org.example.model;

/*import jakarta.persistence.Entity;

import jakarta.persistence.Id;*/

import lombok.Data;

//@Entity
@Data
public class Record {

    //@Id
    private String recordType;
    private String contentIndicator;
    private String fileNumber;
    private String registrationNumber;
    private String uniqueSystemIdentifier;
    private String applicationPurpose;
    private String previousPurpose;
    private String inputSourceCode;
    private String statusCode;
    private String dateEntered;
    private String dateReceived;
    private String dateIssued;
    private String dateConstructed;
    private String dateDismantled;
    private String dateAction;
    private String archiveFlagCode;
    private int versionInteger;
    private String signatureFirstName;
    private String signatureMiddleInitial;
    private String signatureLastName;
    private String signatureSuffix;
    private String signatureTitle;
    private String invalidSignature;
    private String structureStreetAddress;
    private String structureCity;
    private String structureState;
    private String countyCode;
    private String zipCodeVarchar;
    private String heightOfStructure;
    private String groundElevation;
    private String overallHeightAboveGround;
    private String overallHeightAmsl;
    private String structureType;
    private String dateFaaDeterminationIssued;
    private String faaStudyNumber;
    private String faaCircularNumber;
    private String specificationOption;
    private String paintingAndLighting;
    private String proposedMarkingAndLighting;
    private String markingAndLightingOther;
    private String faaEmiFlag;
    private String nepaFlag;
    private String dateSigned;
    private String assignorSignatureLastName;
    private String assignorSignatureFirstName;
    private String assignorSignatureMiddleInitial;
    private String assignorSignatureSuffix;
    private String assignorSignatureTitle;
    private String assignorDateSigned;

    // Getters and setters
}
