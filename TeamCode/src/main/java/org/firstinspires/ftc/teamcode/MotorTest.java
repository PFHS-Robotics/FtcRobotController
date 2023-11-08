package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "MotorTest")
public class MotorTest extends LinearOpMode {

// ----------EDIT ONLY BELOW----------

    // Other Variables
    // Code

    // Methods
    //Code


    @Override
    public void runOpMode() {

        // Motor variables
        DcMotor backRight = hardwareMap.get(DcMotor.class, "BackRight");
        DcMotor backLeft = hardwareMap.get(DcMotor.class, "BackLeft");
        DcMotor frontRight = hardwareMap.get(DcMotor.class, "FrontRight");
        DcMotor frontLeft = hardwareMap.get(DcMotor.class, "FrontLeft");
        // Put initialization blocks here.
        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.
            while (opModeIsActive()) {
                // Back Right (0)
                backRight.setPower(4);
                backRight.setDirection(DcMotorSimple.Direction.REVERSE);
                // Front Right (2)
                frontRight.setPower(4);
                frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
                // Back Left (1)
                backLeft.setPower(4);
                // Front Left (3)
                frontLeft.setPower(4);
            }
        }
    }
}