package app.storage;

import app.geometry2d.Figure;
import app.exceptions.InvalidFigureRecordException;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface FigureStorage {

    List<Figure> read(Path path)
            throws IOException, InvalidFigureRecordException,
            ClassNotFoundException;

    void write(Path path, List<Figure> figures)
            throws IOException;
}