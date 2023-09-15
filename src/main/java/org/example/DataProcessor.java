//package org.example;
//
//import org.datavec.api.records.reader.RecordReader;
//import org.datavec.api.records.reader.impl.csv.CSVRecordReader;
//import org.datavec.api.split.FileSplit;
//import org.datavec.api.split.InputSplit;
//import org.datavec.api.util.ClassPathResource;
//import org.datavec.api.writable.Writable;
//import org.datavec.api.writable.Text;
//import org.datavec.api.transform.schema.Schema;
////import org.datavec.local.transforms.LocalTransformExecutor;
//import org.datavec.api.transform.TransformProcess;
////import org.datavec.local.transforms.LocalTransformExecutor;
//import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
//
//import java.io.File;
//import java.util.List;
//
//public class DataProcessor {
//    public static DataSetIterator prepareData(String csvFilePath) throws Exception {
//        RecordReader rr = new CSVRecordReader(1); // Skip the header row
//        rr.initialize(new FileSplit(new File(csvFilePath)));
//
//        Schema schema = new Schema.Builder()
//                .addColumnString("question")
//                .addColumnString("answer")
//                .build();
//
//        TransformProcess tp = new TransformProcess.Builder(schema)
//                .removeColumns("answer") // We only need the "question" column for input
//                .build();
//
//        List<List<Writable>> originalData = LocalTransformExecutor.execute((List<List<Writable>>) rr, tp);
//
//        // Process your data to create input/output pairs
//        // ...
//
//        // Create and return a DataSetIterator
//        // ...
//    }
//}
