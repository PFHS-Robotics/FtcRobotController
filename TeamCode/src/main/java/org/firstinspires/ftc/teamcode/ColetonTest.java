
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "ColetonTest")
public class ColetonTest extends LinearOpMode {

// ----------EDIT ONLY BELOW----------

    // Sensor variabled
    ColorSensor color;
    // Motor variables
    private DcMotor BackRight;
    private DcMotor BackLeft;
    private DcMotor FrontRight;
    private DcMotor FrontLeft;

    //Other Variables
    int x = 10;
    int y = 10;
    float left;
    float right;


    // Methods
    void move(){
        // Back Right (0)
        BackRight.setPower(4 * gamepad1.left_stick_y);
        BackRight.setDirection(DcMotorSimple.Direction.REVERSE);
        // Front Right (2)
        FrontRight.setPower(4 * gamepad1.left_stick_y);
        FrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        // Back Left (1)
        BackLeft.setPower(4 * gamepad1.left_stick_y);
        // Front Left (3)
        FrontLeft.setPower(4 * gamepad1.left_stick_y);
    }

    void turn(){
        // Back Right (0)
        BackRight.setPower(4 * gamepad1.right_stick_x);
        BackRight.setDirection(DcMotorSimple.Direction.REVERSE);
        // Back Left (1)
        BackLeft.setPower(-(4 * gamepad1.right_stick_x));
        // Front Right (2)
        FrontRight.setPower(-(4 * gamepad1.right_stick_x));
        FrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        // Front Left (3)
        FrontLeft.setPower(4 * gamepad1.right_stick_x);
    }
    void strongTurn(){
        if (gamepad1.right_bumper) {
            // Back Right (0)
            BackRight.setPower(4);
            BackRight.setDirection(DcMotorSimple.Direction.REVERSE);
            // Back Left (1)
            BackLeft.setPower(-4);
            // Front Right (2)
            FrontRight.setPower(-4);
            FrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
            // Front Left (3)
            FrontLeft.setPower(4);
            sleep(625);
        } else {
            BackRight.setPower(0);
            BackLeft.setPower(0);
            FrontRight.setPower(0);
            FrontLeft.setPower(0);
        }
        if (gamepad1.left_bumper) {
            // Back Right (0)
            BackRight.setPower(-4);
            BackRight.setDirection(DcMotorSimple.Direction.FORWARD);
            // Back Left (1)
            BackLeft.setPower(4);
            // Front Right (2)
            FrontRight.setPower(4);
            FrontRight.setDirection(DcMotorSimple.Direction.FORWARD);
            // Front Left (3)
            FrontLeft.setPower(-4);
            sleep(625);
        } else {
            BackRight.setPower(0);
            BackLeft.setPower(0);
            FrontRight.setPower(0);
            FrontLeft.setPower(0);
        }
    }

    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */

    @Override
    public void runOpMode() {
        // Hardware map
        BackRight = hardwareMap.get(DcMotor.class, "BackRight");
        BackLeft = hardwareMap.get(DcMotor.class, "BackLeft");
        FrontRight = hardwareMap.get(DcMotor.class, "FrontRight");
        FrontLeft = hardwareMap.get(DcMotor.class, "FrontLeft");

        waitForStart();
        if (opModeIsActive()) {
            // Put run code
            while (opModeIsActive()) {
                left = gamepad1.left_stick_y;
                right = gamepad1.right_stick_x;
                // -------------- FORWARDS /BACKWARDS --------------
                if(x >= 10){
                    move();
                    y = 0;
                }
                if(left <= 0 && left  >= 0){
                    y = 10;
                }
                // TURNING
                if(y >= 10){
                    turn();
                    x = 0;
                }
                if(right <= 0 && right >= 0 ){
                    x = 10;
                }
                // Strong Turn
                if(y >= 10 && x >= 10){
                    strongTurn();
                }
            }
        }
    }
}
