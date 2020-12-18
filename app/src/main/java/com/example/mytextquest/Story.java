package com.example.mytextquest;


// =======история=======
public class Story {

    private Situation start_story[]=new Situation[4];
    public Situation current_situation;

    Story() {

        start_story[0] = new Situation("STORY1.1",
        // Start
                "Только что вы окончили курс 'мобильная разработка' и теперь хотите опробовать себя в роли хакера. " +
                        "Как известно, бывают белые хакеры, те, которые совершают дела ради улучшения безопасности и получают за это вознаграждение " +
                        "и черные, забирают то, что плохо защищено.",
                0, 0, 0, 0);
        start_story[0].direction[0] = new Situation("STORY1.2",

                "Каждый день вы будете читать новость, оценивать ее и решать, за кого будете играть в этот раз.",
                0, 0, 0, 0);
        //Question1
        start_story[0].direction[0].direction[0] = new Situation("DAY1",
                "День 1,\nВаш сосед по парте оставил телефон включеным. Захотите ли вы пробраться в телефон и заполучить какую либо информацию " +
                        "или же просто выключите его",3,0,0,0);
        //Answers
        start_story[0].direction[0].direction[0].direction[1] = new Situation("ANSDAY1.1",
                "Вы выключили телефон, чтобы никто не смог воспользоваться им. Вернувшись, хозяин телефона ничего не заметил."
                ,0,0,1,0);
        start_story[0].direction[0].direction[0].direction[2] = new Situation("ANSDAY1.2",
                "Вы пробрались в его галерею и удалили все фотографии, вместе с тем нашли ответы на кр. После выключили телефон.\n Ух, вы - бесстыдник!\n Я ваш поклонник",
                0,1,0,1);
        start_story[0].direction[0].direction[0].direction[3] = new Situation("ANSDAY1.3",
                "Сосед вернулся и увидел, что его телефон разблокирован. Подумал, что вы лазили в его телефоне и больше не дает вам списывать домашку.",
                0,0,0,0);
        current_situation = start_story[0];
        //Question2
        start_story[1]=new Situation("DAY2","День 2,\nСегодня вы целый день провели за игрой в Контр-страйк 1.6. Вас разозлил соперник своей непрофисиональностью и детским подходом к игре, и вы пообещали вычислить его по айпи.",
                3,0,0,0);
        //direct
        start_story[0].direction[0].direction[0].direction[1].direction[0]=start_story[1];
        start_story[0].direction[0].direction[0].direction[2].direction[0]=start_story[1];
        start_story[0].direction[0].direction[0].direction[3].direction[0]=start_story[1];
        //Answers
        start_story[1].direction[1]=new Situation("ANSDAY2.1",
                "Вы решили, что ваш соперник не стоит таких усилий и просто напросто показали кто тут батька, побеждая команду соперника снова и снова.",
                0,1,0,5);
        start_story[1].direction[2]=new Situation("ANSDAY2.2",
                "Вычислить его айпи было проше простого и вы удаленно выключили его комп и удалили Контр-страйк. Вы герой для всего комьюнити этой игры!",
                0,0,1,10);
        start_story[1].direction[3]=new Situation("ANSDAY2.3",
                "Вы подумали, что на сегодня хватит игр и пошли делать домашку",0,0,0,0);
        //END
        start_story[2]=new Situation("END1.1","Конец\n\n\n\n\nНажмите чтобы завершить...",
                0,0,0,0);
        start_story[1].direction[1].direction[0]=start_story[2];
        start_story[1].direction[2].direction[0]=start_story[2];
        start_story[1].direction[3].direction[0]=start_story[2];

        start_story[3]=new Situation("END1.2","", 0,0,0,0);
        start_story[2].direction[0]=start_story[3];


    }

    public void go(int num) {
            current_situation = current_situation.direction[num - 1];
    }

    public boolean isEnd() {
        return current_situation.direction.length == 0;
    }

}

