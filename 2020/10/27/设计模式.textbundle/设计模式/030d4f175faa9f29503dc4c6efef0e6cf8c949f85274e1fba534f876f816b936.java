public class Main {
    public static void main(String[] args) {
        Phone iphone = new Iphone();
        Phone musicIPhone = new MusicPhone(iphone);
        Phone giveCurrentTimeIPhone = new GiveCurrentTimePhone(musicIPhone);
        giveCurrentTimeIPhone.call();
    }
}