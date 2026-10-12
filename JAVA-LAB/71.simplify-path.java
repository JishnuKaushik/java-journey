class Solution {
    public String simplifyPath(String path) {
        Deque<String> st = new ArrayDeque<>();
        String[] parts = path.split("/");
        for(String p : parts){
            if(p.equals("") || p.equals(".")) continue;
            if(p.equals("..")){
                if(!st.isEmpty()) st.pop();
            }else{
                st.push(p);
            }
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = st.descendingIterator();
        while(it.hasNext()){
            sb.append("/");
            sb.append(it.next());
        }
        if(sb.length()==0) return "/";
        return sb.toString();
    }
}
