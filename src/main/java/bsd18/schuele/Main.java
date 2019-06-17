package bsd18.schuele;

import javax.persistence.Persistence;

public class Main {


        public static void main(String[] args) {
            Persistence.generateSchema("samplePU", null);
        }

}
