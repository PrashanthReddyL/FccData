package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "RA_DATA", schema = "dbo")
@Data
public class Record {


    @Column(name = "RECORDTYPE", nullable = false)
    private String recordType;

    @Column(name = "CONTENTINDICATOR")
    private String contentIndicator;

    @Column(name = "FILENUMBER")
    private String fileNumber;

    @Column(name = "REGISTRATIONNUMBER")
    private String registrationNumber;
    @Id
    @Column(name = "UNIQUESYSTEMIDENTIFIER", nullable = false)
    private String uniqueSystemIdentifier;

    @Column(name = "APPLICATIONPURPOSE")
    private String applicationPurpose;

    @Column(name = "PREVIOUSPURPOSE")
    private String previousPurpose;

    @Column(name = "INPUTSOURCECODE")
    private String inputSourceCode;

    @Column(name = "STATUSCODE")
    private String statusCode;

    @Column(name = "DATEENTERED")
    private String dateEntered;

    @Column(name = "DATERECEIVED")
    private String dateReceived;

    @Column(name = "DATEISSUED")
    private String dateIssued;

    @Column(name = "DATECONSTRUCTED")
    private String dateConstructed;

    @Column(name = "DATEDISMANTLED")
    private String dateDismantled;

    @Column(name = "DATEACTION")
    private String dateAction;

    @Column(name = "ARCHIVEFLAGCODE")
    private String archiveFlagCode;

    @Column(name = "VERSIONINTEGER")
    private Integer versionInteger;

    @Column(name = "SIGNATUREFIRSTNAME")
    private String signatureFirstName;

    @Column(name = "SIGNATUREMIDDLEINITIAL")
    private String signatureMiddleInitial;

    @Column(name = "SIGNATURELASTNAME")
    private String signatureLastName;

    @Column(name = "SIGNATURESUFFIX")
    private String signatureSuffix;

    @Column(name = "SIGNATURETITLE")
    private String signatureTitle;

    @Column(name = "INVALIDSIGNATURE")
    private String invalidSignature;

    @Column(name = "STRUCTURESTREETADDRESS")
    private String structureStreetAddress;

    @Column(name = "STRUCTURECITY")
    private String structureCity;

    @Column(name = "STRUCTURESTATE")
    private String structureState;

    @Column(name = "COUNTYCODE")
    private String countyCode;

    @Column(name = "ZIPCODEVARCHAR")
    private String zipCodeVarchar;

    @Column(name = "HEIGHTOFSTRUCTURE")
    private String heightOfStructure;

    @Column(name = "GROUNDELEVATION")
    private String groundElevation;

    @Column(name = "OVERALLHEIGHTABOVEGROUND")
    private String overallHeightAboveGround;

    @Column(name = "OVERALLHEIGHTAMSL")
    private String overallHeightAMSL;

    @Column(name = "STRUCTURETYPE")
    private String structureType;

    @Column(name = "DATEFAADETERMINATIONISSUED")
    private String dateFaaDeterminationIssued;

    @Column(name = "FAASTUDYNUMBER")
    private String faaStudyNumber;

    @Column(name = "FAACIRCULARNUMBER")
    private String faaCircularNumber;

    @Column(name = "SPECIFICATIONOPTION")
    private String specificationOption;

    @Column(name = "PAINTINGANDLIGHTING")
    private String paintingAndLighting;

    @Column(name = "PROPOSEDMARKINGANDLIGHTING")
    private String proposedMarkingAndLighting;

    @Column(name = "MARKINGANDLIGHTINGOTHER")
    private String markingAndLightingOther;

    @Column(name = "FAAEMIFLAG")
    private String faaEMIFlag;

    @Column(name = "NEPAFLAG")
    private String nepaFlag;

    @Column(name = "DATESIGNED")
    private String dateSigned;

    @Column(name = "ASSIGNORSIGNATURELASTNAME")
    private String assignorSignatureLastName;

    @Column(name = "ASSIGNORSIGNATUREFIRSTNAME")
    private String assignorSignatureFirstName;

    @Column(name = "ASSIGNORSIGNATUREMIDDLEINITIAL")
    private String assignorSignatureMiddleInitial;

    @Column(name = "ASSIGNORSIGNATURESUFFIX")
    private String assignorSignatureSuffix;

    @Column(name = "ASSIGNORSIGNATURETITLE")
    private String assignorSignatureTitle;

    @Column(name = "ASSIGNORDATESIGNED")
    private String assignorDateSigned;

    // Getters and setters
}
