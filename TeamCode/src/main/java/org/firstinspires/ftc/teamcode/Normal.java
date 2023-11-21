
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Normal")
public class Normal extends LinearOpMode {

// ----------EDIT ONLY BELOW----------

    // Motor variables
    private DcMotor BackRight;
    private DcMotor BackLeft;
    private DcMotor FrontRight;
    private DcMotor FrontLeft;

    //Other Variables
    boolean moving;
    boolean turning;

    // Methods
    void move(){
        if(!turning) {
            BackRight.setPower(4 * gamepad1.left_stick_y);
            BackLeft.setPower(4 * gamepad1.left_stick_y);
            FrontRight.setPower(4 * gamepad1.left_stick_y);
            FrontLeft.setPower(4 * gamepad1.left_stick_y);
        }
    }

    void turn(){
        if(!moving) {
            BackRight.setPower(4 * gamepad1.right_stick_x);
            BackLeft.setPower(-4 * gamepad1.right_stick_x);
            FrontRight.setPower((4 * gamepad1.right_stick_x));
            FrontLeft.setPower(-4 * gamepad1.right_stick_x);
        }
    }

    void hardTurn(){
        if(!turning  && !moving) {
            // Right Turn
            if (gamepad1.right_bumper) {
                // Turn
                BackRight.setPower(-4);
                BackLeft.setPower(4);
                FrontRight.setPower(-4);
                FrontLeft.setPower(4);
                sleep(1200);

                // Stop Turning
                BackRight.setPower(0);
                BackLeft.setPower(0);
                FrontRight.setPower(0);
                FrontLeft.setPower(0);
            }
            // Left Turn
            if (gamepad1.left_bumper) {
                // Turn
                BackRight.setPower(4);
                BackLeft.setPower(-4);
                FrontRight.setPower(4);
                FrontLeft.setPower(-4);
                sleep(1200);

                // Stop Turning
                BackRight.setPower(0);
                BackLeft.setPower(0);
                FrontRight.setPower(0);
                FrontLeft.setPower(0);
            }
        }
    }

    void turningWhileMovingFix(){
        //Moving
        moving = gamepad1.left_stick_y != 0;

        //Turning
        turning = gamepad1.right_stick_x != 0;
    }

    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */

    @Override
    public void runOpMode() {

        BackRight = hardwareMap.get(DcMotor.class, "BackRight");
        BackLeft = hardwareMap.get(DcMotor.class, "BackLeft");
        FrontRight = hardwareMap.get(DcMotor.class, "FrontRight");
        FrontLeft = hardwareMap.get(DcMotor.class, "FrontLeft");

        // Put initialization blocks here.
        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.
            // Right Side Flipped
            BackRight.setDirection(DcMotorSimple.Direction.REVERSE);
            FrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
            // Don't Turn While Moving
            moving = gamepad1.left_stick_y != 0;
            turning = gamepad1.right_stick_x != 0;
            while (opModeIsActive()) {
                //Methods
                turningWhileMovingFix();
                move();
                turn();
                hardTurn();
            }
        }
    }
}
