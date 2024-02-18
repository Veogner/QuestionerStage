package org.firstinspires.ftc.teamcode.uncommon.hardware;

import android.util.Size;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.VisionProcessor;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

@Config
public class RobotHardware {

    //Drivetrain Initialization for Motors sm(Orientation)(Orientation)
    public DcMotorEx smFrontLeft;
    public DcMotorEx smFrontRight;
    public DcMotorEx smBackLeft;
    public DcMotorEx smBackRight;

    //Hardware Map Import
    private HardwareMap hardwareMap;
    private static RobotHardware instance = null;
    private boolean enabled;


    //Vision Portal for Webcam Recognition
    private VisionPortal visionPortal;
    private AprilTagProcessor aprilTag;

    //Time importation statement for PIDF controller and voltage
    private ElapsedTime voltageTimer = new ElapsedTime();
    private double voltage = 12.0;


    //Class contractor to access the file for easy access to the RobotHardware class
    public static RobotHardware getInstance() {
        if (instance == null) {
            instance = new RobotHardware();
        }
        instance.enabled = true;
        return instance;
    }

    //Initialization of all variables including the Motors and Servos
    public void init(final HardwareMap hardwareMap){
        this.hardwareMap = hardwareMap;

        //Drivetrain Motors
        this.smFrontLeft = hardwareMap.get(DcMotorEx.class, "FLeft");
        smFrontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        this.smFrontRight = hardwareMap.get(DcMotorEx.class, "FRight");
        smFrontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        this.smBackLeft = hardwareMap.get(DcMotorEx.class, "BLeft");
        smBackLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        this.smBackRight = hardwareMap.get(DcMotorEx.class, "BRight");
        smBackRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }


}
