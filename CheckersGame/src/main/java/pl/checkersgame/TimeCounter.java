package pl.checkersgame;

import java.util.ArrayList;
import java.util.List;

public class TimeCounter {

    public long timeStart;
    public long timeStop;
    List<Long> redPieceTime = new ArrayList<>();
    List<Long> goldPieceTime = new ArrayList<>();


    public void setTimeStart(){
        this.timeStart = System.nanoTime();
    }

    public void setTimeStop(Piece piece){
        this.timeStop = System.nanoTime()-timeStart;
        if (piece.getPieceType().equals(PieceType.RED)){
            redPieceTime.add(timeStop);
        } else if (piece.getPieceType().equals(PieceType.GOLD)){
            goldPieceTime.add(timeStop);
        }
    }

    public long sumAllTime(List<Long> timeList){
        return timeList.stream().mapToLong(time -> time).sum();
    }

    public List<Long> getRedPieceTime() {
        return redPieceTime;
    }

    public List<Long> getGoldPieceTime() {
        return goldPieceTime;
    }

}
