package com.day16;

import java.util.Arrays;
import java.util.Scanner;

public class TaskScheduling {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of tasks: ");
        int n = scanner.nextInt();
        Task[] tasks = new Task[n];

        System.out.println("Enter the deadline and minutes for each task:");

        for (int i = 0; i < n; i++) {
            System.out.print("Task " + (i + 1) + ": ");
            int deadline = scanner.nextInt();
            int minutes = scanner.nextInt();
            tasks[i] = new Task(deadline, minutes);
        }

        Arrays.sort(tasks);

        int[] maxOvershoots = new int[n];
        int currentCompletionTime = 0;

        for (int i = 0; i < n; i++) {
            currentCompletionTime += tasks[i].minutes;
            maxOvershoots[i] = Math.max(0, currentCompletionTime - tasks[i].deadline);
        }

        System.out.println("\nMaximum overshoot for each task (in minutes):");

        for (int i = 0; i < n; i++) {
            System.out.println("Task " + (i + 1) + ": " + maxOvershoots[i]);
        }

        scanner.close();
    }

    static class Task implements Comparable<Task> {
        int deadline;
        int minutes;

        Task(int deadline, int minutes) {
            this.deadline = deadline;
            this.minutes = minutes;
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.deadline, other.deadline);
        }
    }
}