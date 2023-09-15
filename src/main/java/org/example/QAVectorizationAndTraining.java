package org.example;

import org.datavec.api.records.reader.RecordReader;
import org.datavec.api.records.reader.impl.csv.CSVRecordReader;
import org.datavec.api.split.FileSplit;
import org.datavec.api.writable.Writable;
import org.deeplearning4j.datasets.datavec.RecordReaderDataSetIterator;
import org.deeplearning4j.datasets.iterator.utilty.ListDataSetIterator;
import org.deeplearning4j.nn.conf.Updater;
import org.deeplearning4j.text.tokenization.tokenizer.Tokenizer;
import org.deeplearning4j.text.tokenization.tokenizerfactory.DefaultTokenizerFactory;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
//import org.nd4j.linalg.dataset.api.iterator.impl.ListDataSetIterator;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.learning.config.Adam;
import org.nd4j.linalg.lossfunctions.LossFunctions;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class QAVectorizationAndTraining {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Load your CSV file
        String filePath = "E:\\Developement\\SpringBootAPP\\ML\\Task1\\src\\main\\resources\\Data - Sheet1.csv";



        RecordReader rr = new CSVRecordReader();
        rr.initialize(new FileSplit(new File(filePath)));

        int labelIndex = 1; // Index of the answer column
        int numClasses = 2; // Number of unique answers
        int batchSize = 32; // Mini-batch size

        DataSetIterator iterator = new RecordReaderDataSetIterator(rr, batchSize, labelIndex, numClasses);

        long hiddenSize=20;
        int inputSize=5;
        MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
                .seed(123)
                .updater(new Adam(0.001))
                .list()
                .layer(new DenseLayer.Builder()
                        .nIn(inputSize) // Input size (e.g., word embeddings)
                        .nOut(hiddenSize)
                        .activation(Activation.RELU)
                        .build())
                .layer(new OutputLayer.Builder(LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD)
                        .nIn(hiddenSize)
                        .nOut(numClasses) // Number of unique answers
                        .activation(Activation.SOFTMAX)
                        .build())
                .build();

        MultiLayerNetwork model = new MultiLayerNetwork(conf);
        model.init();

        int numEpochs = 10; // Number of training epochs

        for (int i = 0; i < numEpochs; i++) {
            model.fit(iterator);
        }


        String line;
        Scanner sc=new Scanner(System.in);
        line =sc.nextLine();
        double[] numbers = Arrays.stream(line.split(",")).mapToDouble(Double::parseDouble).toArray();



        INDArray input =Nd4j.create(numbers);
                // Prepare input data for your question
               // INDArray output = model.output(input);

       // INDArray INDArray output = model.output(input);
        INDArray output=model.output(input);

// Decode the output to get the predicted answer
        int predictedClass = Nd4j.argMax(output, 1).getInt(0);

        System.out.println(predictedClass);
        //String predictedAnswer = // Map predictedClass to your answer labels






//                String inputQuestion = "What is the capital of France?";
//
//        // Preprocess the question (tokenization, vectorization, etc.)
//        INDArray inputVector = preprocessQuestion(inputQuestion);
//
//        // Perform inference to get the answer
//        INDArray outputVector = model.output(inputVector);
//        String predictedAnswer = postprocessAnswer(outputVector);
//
//        // Print the predicted answer
//        System.out.println("Predicted Answer: " + predictedAnswer);
    }

    }

