//package org.example;
//
//import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
//import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
//import org.deeplearning4j.nn.conf.layers.*;
//import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
//import org.deeplearning4j.nn.weights.WeightInit;
//import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
//import org.nd4j.linalg.activations.Activation;
//import org.nd4j.linalg.learning.config.Adam;
//import org.nd4j.linalg.lossfunctions.LossFunctions;
//
//public class App {
//    public static MultiLayerNetwork buildModel(int inputSize, int outputSize) {
//        int numHiddenNodes = 128;
//        MultiLayerConfiguration config = new NeuralNetConfiguration.Builder()
//                .seed(12345)
//                .weightInit(WeightInit.XAVIER)
//                .updater(new Adam(0.001))
//                .list()
//                .layer(new LSTM.Builder()
//                        .nIn(inputSize)
//                        .nOut(numHiddenNodes)
//                        .activation(Activation.TANH)
//                        .build())
//                .layer(new RnnOutputLayer.Builder()
//                        .nIn(numHiddenNodes)
//                        .nOut(outputSize)
//                        .activation(Activation.SOFTMAX)
//                        .lossFunction(LossFunctions.LossFunction.MCXENT)
//                        .build())
//                .build();
//
//        MultiLayerNetwork model = new MultiLayerNetwork(config);
//        model.init();
//        model.setListeners(new ScoreIterationListener(1));
//
//        return model;
//    }
//}
