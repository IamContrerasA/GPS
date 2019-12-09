/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GPS;


import java.util.List;
import java.util.Properties;

import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations.CollapsedCCProcessedDependenciesAnnotation;
import edu.stanford.nlp.simple.Document;
import edu.stanford.nlp.simple.Sentence;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations.TreeAnnotation;
import edu.stanford.nlp.util.CoreMap;

/**
 * Hello world!
 *
 */
public class App {
	static public void main(String[] args) {
        //String text = "Posteriormente, el desarrollo urbanístico estuvo marcado por el aumento de la población debido a la inmigración desde otras partes de España, lo que conllevó diversos proyectos urbanísticos como el Plan Comarcal de 1953 o el Plan General Metropolitano de 1976. Igualmente, la adecuación del espacio urbano de la ciudad se ha visto favorecida entre los siglos XIX y XXI por diversos eventos celebrados en la ciudad, como la Exposición Universal de 1888, la Internacional de 1929, el XXXV Congreso Eucarístico Internacional de 1952, los Juegos Olímpicos de 1992 y el Fórum Universal de las Culturas de 2004.";
        String text = "a0as93840kjasd Hristo est dia 3n l4 Escue a pr0fessio0nal de Ingenieria de si te as";
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos");
        props.setProperty("pos.model", "C:\\Users\\intel\\Downloads\\stanford-postagger-full-2018-10-16\\models\\spanish.tagger");
        props.setProperty("pos.maxlen", "500");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        Annotation annotation = new Annotation(text);
        pipeline.annotate(annotation);
        List<CoreMap> sentences = annotation.get(SentencesAnnotation.class);
        for(CoreMap sentence: sentences) {
            for (CoreLabel token: sentence.get(TokensAnnotation.class)) {
                String word = token.get(TextAnnotation.class);
                System.out.println(word + " " + token.get(PartOfSpeechAnnotation.class));
            }
        }
}}