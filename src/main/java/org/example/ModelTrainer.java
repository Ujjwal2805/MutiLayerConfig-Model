//package org.example;
//
//import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
//import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
//import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
//
//public class ModelTrainer {
//    public static void main(String[] args) throws Exception {
//        int inputSize = ...; // Define input size based on your data
//        int outputSize = ...; // Define output size based on your data
//
//        MultiLayerNetwork model = App.buildModel(inputSize, outputSize);
//        DataSetIterator dataIterator = DataProcessor.prepareData("data.csv");
//
//        int numEpochs = 10; // Define the number of training epochs
//
//        for (int i = 0; i < numEpochs; i++) {
//            model.fit(dataIterator);
//        }
//    }
//}
//
