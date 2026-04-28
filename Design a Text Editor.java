class TextEditor {

    StringBuilder left;   // text before cursor
    StringBuilder right;  // text after cursor

    public TextEditor() {
        left = new StringBuilder();
        right = new StringBuilder();
    }

    public void addText(String text) {
        left.append(text);
    }

    public int deleteText(int k) {
        int deleteCount = Math.min(k, left.length());
        left.delete(left.length() - deleteCount, left.length());
        return deleteCount;
    }

    public String cursorLeft(int k) {
        int move = Math.min(k, left.length());

        for (int i = 0; i < move; i++) {
            right.append(left.charAt(left.length() - 1));
            left.deleteCharAt(left.length() - 1);
        }

        return getLast10();
    }

    public String cursorRight(int k) {
        int move = Math.min(k, right.length());

        for (int i = 0; i < move; i++) {
            left.append(right.charAt(right.length() - 1));
            right.deleteCharAt(right.length() - 1);
        }

        return getLast10();
    }

    private String getLast10() {
        int start = Math.max(0, left.length() - 10);
        return left.substring(start);
    }
}
