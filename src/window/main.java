package window;

import javax.swing.*;

public class main {

	public static void main(String[] args) {
		// 建立視窗 JFrame
        JFrame frame = new JFrame("Window");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // 不使用 layout manager

        // 建立一個按鈕
        JButton button = new JButton("clicked me！");
        button.setBounds(140, 30, 100, 30);

        // 建立一個標籤 JLabel
        JLabel label = new JLabel("");
        label.setBounds(130, 80, 200, 30);

        // 按鈕按下後事件
        button.addActionListener(e -> label.setText("Hello World"));

        // 加入到畫面中
        frame.add(button);
        frame.add(label);

        // 顯示畫面
        frame.setVisible(true);

	}

}
