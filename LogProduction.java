public class LogProduction extends Log {

    @Override
    public void log(String text, LogType type) {
        switch (type) {
            case RESULT:
                break;

            case SPEECH:
                break;

            case NARATOR:
                break;
        }

    }

    public void print (String text) {
        System.out.println(text);
    }
}
