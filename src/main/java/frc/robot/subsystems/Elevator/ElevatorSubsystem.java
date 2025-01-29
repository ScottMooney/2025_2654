package frc.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.ClosedLoopConfig;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.ClosedLoopSlot;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

public class ElevatorSubsystem extends SubsystemBase{
    private SparkClosedLoopController m_ClosedLoopController;
    private ClosedLoopConfig m_ClosedLoopConfig = new ClosedLoopConfig();
    private double kP, kI, kD, kFF, kMaxOutput, kMinOutput;
    private SparkMax motor = new SparkMax(19,MotorType.kBrushless);
    private RelativeEncoder c_up = motor.getEncoder();
    private SparkMaxConfig config = new SparkMaxConfig();
    
    public void run(double speed){
        motor.set(speed);
    }
    public void ElevatorGetPos() {
        SmartDashboard.putNumber("Elevator Position", c_up.getPosition());
    }

    public void mbrake(){//brake motor when not moving
        config.idleMode(IdleMode.kBrake);
    }
    // public void Initialize() {
    //     c_up.setPosition(0);// set elevator to zero at power on
    // }
    
    public void ElevatorToPos(double pos) {
        m_ClosedLoopController = motor.getClosedLoopController();//call PID control
        // PID coefficients
        kP = 0.1; 
        kI = 1e-4;
        kD = 1; 
        // kIz = 0; 
        kFF = 0; 
        kMaxOutput = 1; 
        kMinOutput = -1;
        // set PID coefficients, feedforward, & max output
        m_ClosedLoopConfig.pidf(kP,kI,kD,kFF,ClosedLoopSlot.kSlot0);
        m_ClosedLoopConfig.outputRange(kMinOutput, kMaxOutput);
        //set target & control type & slot
        m_ClosedLoopController.setReference(pos,ControlType.kPosition, ClosedLoopSlot.kSlot0);
        m_ClosedLoopConfig.outputRange(kMinOutput, kMaxOutput);
    }

}

