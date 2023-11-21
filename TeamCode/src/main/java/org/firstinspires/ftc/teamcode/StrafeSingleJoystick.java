
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "StrafeSingleJoystick")
public class StrafeSingleJoystick extends LinearOpMode {

// ----------EDIT ONLY BELOW----------

    // Motor variables
    private DcMotor BackRight;
    private DcMotor BackLeft;
    private DcMotor FrontRight;
    private DcMotor FrontLeft;

    //Other Variables
    boolean moving;

    // Methods
    void moveStrafe(){
            BackRight.setPower((4 * gamepad1.left_stick_y) + (4 * gamepad1.left_stick_x));
            BackLeft.setPower((4 * gamepad1.left_stick_y) + (-4 * gamepad1.left_stick_x));
            FrontRight.setPower((4 * gamepad1.left_stick_y) + (-4 * gamepad1.left_stick_x));
            FrontLeft.setPower((4 * gamepad1.left_stick_y) + (4 * gamepad1.left_stick_x));
    }

    void turn(){
            if(!moving) {
                BackRight.setPower(4 * gamepad1.right_stick_x);
                BackLeft.setPower(-4 * gamepad1.right_stick_x);
                FrontRight.setPower((4 * gamepad1.right_stick_x));
                FrontLeft.setPower(-4 * gamepad1.right_stick_x);
            }
    }

    void turningWhileMovingFix(){
        //Moving
        moving = gamepad1.left_stick_y != 0 || gamepad1.left_stick_x != 0;
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
            while (opModeIsActive()) {
                //Variable-Type Things
                BackRight.setDirection(DcMotorSimple.Direction.REVERSE);
                FrontRight.setDirection(DcMotorSimple.Direction.REVERSE);

                //Methods
                turningWhileMovingFix();
                moveStrafe();
                turn();
            }
        }
    }
}
