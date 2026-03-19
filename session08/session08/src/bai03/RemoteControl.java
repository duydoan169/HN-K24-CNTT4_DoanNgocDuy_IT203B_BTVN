package bai03;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RemoteControl {
    private Map<Integer, Command> buttons = new HashMap<>();
    private Stack<Command> history = new Stack<>();

    public void setCommand(int slot, Command command) {
        buttons.put(slot, command);
        System.out.println("Đã gán " + command.getClass().getSimpleName() + " cho nút " + slot);
    }

    public void pressButton(int slot) {
        Command command = buttons.get(slot);
        if (command != null) {
            command.execute();
            history.push(command);
        }
    }

    public void undo() {
        if (!history.isEmpty()) {
            Command lastCommand = history.pop();
            lastCommand.undo();
        }
    }
}
