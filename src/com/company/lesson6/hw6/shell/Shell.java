package com.company.lesson6.hw6.shell;

import java.util.Arrays;

public class Shell {


    interface StepGenerator {
        public int nextStep();
    }

    class ShellStep implements StepGenerator {
        private int step;

        public ShellStep(int[] array) {
            step = array.length / 2;
        }

        @Override
        public int nextStep() {
            step = step / 2;
            return step;
        }

    }


    public class ModifiedShellSort {




        public  void shellSort(int[] array, StepGenerator stepGen) {
            int step = stepGen.nextStep();
            for (; step > 0; ) {
                for (int i = step; i < array.length; i++) {
                    for (int j = i; j >= step && array[j] < array[j - step]; j -= step) {
                        int temp = array[j];
                        array[j] = array[j - step];
                        array[j - step] = temp;
                    }
                }
                step = stepGen.nextStep();
            }

        }
    }
}
