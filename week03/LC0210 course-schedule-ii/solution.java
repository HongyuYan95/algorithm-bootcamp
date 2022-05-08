class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] tokenCourses = new int[numCourses];
        int[] inDegrees = new int[numCourses];
        List<List<Integer>> to = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            to.add(new ArrayList<Integer>());
        }

        for (int[] prerequisite: prerequisites) {
            int child = prerequisite[0];
            int parent = prerequisite[1];
            to.get(parent).add(child);
            inDegrees[child]++;
        }

        Queue<Integer> q = new LinkedList<Integer>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                q.offer(i);
            }
        }

        // System.out.println(Arrays.toString(inDegrees));

        int pointer = 0;
        while (!q.isEmpty()) {
            // System.out.println(q);
            int course = q.poll();
            // System.out.println(course);
            tokenCourses[pointer] = course;
            pointer++;
            for (int childCourse: to.get(course)) {
                inDegrees[childCourse]--;
                if (inDegrees[childCourse] == 0) q.offer(childCourse);
            }
        }
        // 检查是否完成了全部课程
        if (pointer < numCourses - 1) return new int[0];
        return tokenCourses;
    }
}
