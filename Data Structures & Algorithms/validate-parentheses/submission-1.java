class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                stack.add(ch);
            } else {
                if (stack.size() == 0) return false;
                char lastOpen = stack.peek();
                if (ch == map.get(lastOpen)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.size() > 0 ? false : true;
    }
}
