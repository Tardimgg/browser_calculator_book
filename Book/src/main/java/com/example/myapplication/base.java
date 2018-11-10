package com.example.myapplication;

import android.app.Application;

public class base extends Application{

    private static int window = 0;
    private static boolean check = false;
    private static int progress = 0;
    private static int method0 = 0;
    private static boolean default_settings = false;
    private static boolean restart = false;
    private static boolean default_fout = false;
    private static boolean progress_check = false;
    private static int method2 = 0;
    private static int progress_size = 0;
    private static int method1 = 0;
    private static boolean check_box_size = false;
    private static boolean check_size_back = false;
    private static int admin_old_view = 0;

    public static int output_window() {
        return window;
    }
    public static void input_window(int number) {
        window = number;
    }
    public static boolean output_check() {
        return check;
    }
    public static void input_check(boolean number) {
        check = number;
    }
    public static int output_progress() {
        return progress;
    }
    public static void input_progress(int number) {
        progress = number;
    }
    public static int output_method() {
        return method0;
    }
    public static void input_method(int number) {
        method0 = number;
    }
    public static boolean output_default_settings() {
        return default_settings;
    }
    public static void input_default_settings(boolean number) {
        default_settings = number;
    }
    public static boolean output_restart() {
        return restart;
    }
    public static void input_restart(boolean number) {
        restart = number;
    }
    public static boolean output_default_fout() {
        return default_fout;
    }
    public static void input_default_fout(boolean number) {
        default_fout = number;
    }
    public static boolean output_progress_boolean (){
        return progress_check;
    }
    public static void input_progress_boolean(boolean number){
        progress_check = number;
    }
    public static int output_method_check_box(){
        return method2;
    }
    public static void input_method_check_box(int number){
        method2 = number;
    }
    public static int output_progress_size(){
        return progress_size;
    }
    public static void input_progress_size(int number){
        progress_size = number;
    }
    public static int output_method_size(){
        return method1;
    }
    public static void input_method_size(int number){
        method1 = number;
    }
    public static boolean output_check_box_size(){
        return check_box_size;
    }
    public static void input_check_box_size(boolean number){
        check_box_size = number;
    }
    public static boolean output_check_size_back(){
        return check_size_back;
    }
    public static void input_check_size_back(boolean number){
        check_size_back = number;
    }
    public static int output_admin_old_view(){
        return admin_old_view;
    }
    public static void input_admin_old_view(int number){
        admin_old_view = number;
    }
}