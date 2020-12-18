package com.example.mytextquest;

import android.widget.TextView;

import java.util.Random;

public class DelayedPrinter {

    public static void printText(final Word word, final TextView textView) {
        Random random = new Random(System.currentTimeMillis());
        //рандомный значение в заданом интервале
        int currentRandOffset = random.nextInt(word.offset);
        //прибавить или отнять
        boolean addOrSubtract = random.nextBoolean();
        //получаем итоговое значение delay
        long finalDelay = addOrSubtract ? word.delayBetweenSymbols + currentRandOffset : word.delayBetweenSymbols - currentRandOffset;
        if (finalDelay < 0) finalDelay = 0;
        //печатание слова по буквам с задержкой
        textView.postDelayed(new Runnable() {
            @Override
            public void run() {
                String charAt = String.valueOf(word.word.charAt(word.currentCharacterIndex));
                ++word.currentCharacterIndex;
                textView.setText(textView.getText() + charAt);
                if (word.currentCharacterIndex >= word.word.length()){
                    word.currentCharacterIndex = 0;
                    return;
                }
                printText(word, textView);
            }
        }, finalDelay);
    }

    
    public static class Word {

        private long delayBetweenSymbols;
        private String word;
        private int offset;
        private int currentCharacterIndex;

        public Word(long delayBetweenSymbols, String word) {
            if (delayBetweenSymbols < 0) throw new IllegalArgumentException("Delay can't be < 0");
            this.delayBetweenSymbols = delayBetweenSymbols;
            this.word = word;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }
    }

}
