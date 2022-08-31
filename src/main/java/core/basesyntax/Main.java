package core.basesyntax;

import core.basesyntax.model.OperationsList;
import core.basesyntax.model.Transaction;
import core.basesyntax.servise.DataOperationHandler;
import core.basesyntax.servise.FileReader;
import core.basesyntax.servise.impl.DataOperationHandlerImpl;
import core.basesyntax.servise.impl.FileReaderImpl;
import core.basesyntax.servise.impl.ReportGeneratorImpl;
import core.basesyntax.servise.impl.ReportWriterImpl;
import core.basesyntax.strategy.OperationStrategy;
import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File input = new File("C:\\Users\\Thousandfold\\IdeaProjects"
                + "\\jv-fruit-shop\\src\\main\\resources\\input");
        FileReader reader = new FileReaderImpl();
        DataOperationHandler operationHandler = new DataOperationHandlerImpl();
        reader.read(input);
        List<Transaction> list = operationHandler.handle();
        System.out.println(OperationsList.list);
        for (Transaction transaction : list) {
            OperationStrategy.getOperation(transaction);
        }
        File file = new ReportWriterImpl().write(new ReportGeneratorImpl()
                .generateReport());
        System.out.println(file);
    }

}