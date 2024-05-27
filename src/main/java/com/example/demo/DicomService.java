package com.example.demo;

import org.dcm4che3.data.Attributes;
import org.dcm4che3.io.DicomInputStream;
import org.dcm4che3.io.DicomOutputStream;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class DicomService {

    public void readAndWriteDicom() {
        String inputFilePath = "C:\\Users\\KIIT\\Downloads\\dicom_viewer_0002\\0002.DCM";
        String outputFilePath = "C:\\Users\\KIIT\\Downloads\\dicom_viewer_0002\\0003.DCM";
        File inputFile = new File(inputFilePath);
        File outputFile = new File(outputFilePath);

        try (DicomInputStream dis = new DicomInputStream(inputFile)) {
            Attributes dicomAttributes = dis.readDataset();

            try (DicomOutputStream dos = new DicomOutputStream(outputFile)) {
                dos.writeDataset(dicomAttributes.createFileMetaInformation(dis.getTransferSyntax()), dicomAttributes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}