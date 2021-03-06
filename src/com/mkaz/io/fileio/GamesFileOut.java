package com.mkaz.io.fileio;

import com.mkaz.Game;
import com.mkaz.GamesLibrary;

import java.util.ArrayList;
import java.util.List;

public class GamesFileOut {
    private final GamesLibrary gamesLibrary;
    private final List<String> gamesInfo = new ArrayList<>();

    public GamesFileOut(GamesLibrary gamesLibrary) {
        this.gamesLibrary = gamesLibrary;
        initialize();
    }

    private void addFirstLine() {
        gamesInfo.add("\"" + "Title:" + "\"" + "\t" + "\"" + "Description:" + "\"" + "\t" + "\"" + "ReleaseYear:"
                + "\"" + "\t" + "\"" + "Genre:" + "\"" + "\t" + "\"" + "Platform:" + "\"");
    }

    private void initialize() {
        addFirstLine();
        StringBuilder stringBuilder;
        for (Game game : gamesLibrary.getGames()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("\"");
            stringBuilder.append(game.getTitle());
            stringBuilder.append("\"");
            stringBuilder.append("\t");
            stringBuilder.append("\"");
            stringBuilder.append(game.getDescription());
            stringBuilder.append("\"");
            stringBuilder.append("\t");
            stringBuilder.append("\"");
            stringBuilder.append(game.getReleaseYear());
            stringBuilder.append("\"");
            stringBuilder.append("\t");
            stringBuilder.append("\"");
            stringBuilder.append(game.getGenre());
            stringBuilder.append("\"");
            stringBuilder.append("\t");
            stringBuilder.append("\"");
            stringBuilder.append(game.getPlatform());
            stringBuilder.append("\"");
            gamesInfo.add(stringBuilder.toString());
        }
    }

    public void write(String fileName) {
        TextFileIO.write(fileName, gamesInfo);
    }
}
