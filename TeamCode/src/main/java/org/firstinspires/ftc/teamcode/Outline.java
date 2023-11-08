package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Outline")
public class Outline extends LinearOpMode {

// ----------EDIT ONLY BELOW----------

    // Other Variables
    // Code

    // Methods
    //Code


    @Override
    public void runOpMode() {

        // Motor variables
        DcMotor PLACEHOLDER1 = hardwareMap.get(DcMotor.class, "PLACEHOLDER1");
        DcMotor PLACEHOLDER2 = hardwareMap.get(DcMotor.class, "PLACEHOLDER2");
        DcMotor PLACEHOLDER3 = hardwareMap.get(DcMotor.class, "PLACEHOLDER3");
        DcMotor PLACEHOLDER4 = hardwareMap.get(DcMotor.class, "PLACEHOLDER4");

        // Put initialization blocks here.
        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.
            while (opModeIsActive()) {
               // Code
            }
        }
    }
}