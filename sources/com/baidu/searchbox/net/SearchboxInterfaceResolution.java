package com.baidu.searchbox.net;

import android.text.TextUtils;
import android.util.Xml;
import com.baidu.searchbox.net.parser.CommandsParser;
import com.baidu.searchbox.net.update.CommandParser;
import com.baidu.searchbox.push.PushManager;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class SearchboxInterfaceResolution {
    private static final boolean DEBUG = false;
    public static final String PUSH_INFO_COMMAND = "pushreg";
    public static final String STATUS = "status";
    private static final String TAG = SearchboxInterfaceResolution.class.getSimpleName();

    private SearchboxInterfaceResolution() {
    }

    public static ArrayList<CommandParser.Command> parseData(InputStream in) throws XmlPullParserException, IOException {
        ArrayList<CommandParser.Command> commands = null;
        XmlPullParser parser = Xml.newPullParser();
        parser.setInput(in, "UTF-8");
        for (int eventType = parser.getEventType(); eventType != 1; eventType = parser.next()) {
            switch (eventType) {
                case 0:
                    commands = new ArrayList<>();
                    break;
                case 2:
                    String tagName = parser.getName();
                    if (!tagName.equalsIgnoreCase(CommandsParser.TAG_DO)) {
                        tagName.equalsIgnoreCase(CommandsParser.TAG_APPCOMMAND);
                        break;
                    } else {
                        CommandParser.Command command = new CommandParser.Command();
                        parseCommandData(command, parser);
                        commands.add(command);
                        break;
                    }
                case 3:
                    parser.getName().equalsIgnoreCase(CommandsParser.TAG_APPCOMMAND);
                    break;
            }
        }
        in.close();
        return commands;
    }

    private static void parseCommandData(CommandParser.Command command, XmlPullParser parser) throws XmlPullParserException, IOException {
        int eventType = parser.getEventType();
        while (eventType != 1) {
            switch (eventType) {
                case 2:
                    String tagName = parser.getName();
                    if (!tagName.equalsIgnoreCase("action")) {
                        if (!tagName.equalsIgnoreCase(CommandsParser.TAG_DATA_SET)) {
                            break;
                        } else {
                            CommandParser.DataSet dataSet = new CommandParser.DataSet();
                            command.setDataSet(dataSet);
                            parseDataSet(dataSet, parser, command.getAction());
                            break;
                        }
                    } else {
                        command.setAction(parser.nextText());
                        break;
                    }
                case 3:
                    if (!parser.getName().equalsIgnoreCase(CommandsParser.TAG_DO)) {
                        break;
                    } else {
                        return;
                    }
            }
            eventType = parser.next();
        }
    }

    private static void parseDataSet(CommandParser.DataSet dataSet, XmlPullParser parser, String commandName) throws XmlPullParserException, IOException {
        dataSet.setVersion(parser.getAttributeValue((String) null, "version"));
        int eventType = parser.getEventType();
        while (eventType != 1) {
            switch (eventType) {
                case 2:
                    if (!parser.getName().equalsIgnoreCase("data")) {
                        break;
                    } else {
                        CommandParser.Data data = null;
                        if (TextUtils.equals(commandName, "pushreg")) {
                            data = new PushManager.PushInfo();
                            parsePushInfo((PushManager.PushInfo) data, parser);
                        }
                        dataSet.getDatas().add(data);
                        break;
                    }
                case 3:
                    if (!parser.getName().equalsIgnoreCase(CommandsParser.TAG_DATA_SET)) {
                        break;
                    } else {
                        return;
                    }
            }
            eventType = parser.next();
        }
    }

    private static void parsePushInfo(PushManager.PushInfo data, XmlPullParser parser) throws XmlPullParserException, IOException {
        data.setStatus(parser.getAttributeValue((String) null, "status"));
        data.setContent(parser.nextText());
    }
}
