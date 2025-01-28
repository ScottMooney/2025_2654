package frc.robot.commands.Elevator;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Elevator.ElevatorArmSubsystem;

public class ElevatorArmCommand extends Command{
    private final ElevatorArmSubsystem m_ElevatorArmSubsystem;
    private final double speed;

    public ElevatorArmCommand(
    ElevatorArmSubsystem c_ElevatorArmSubsystem,
    double speed
    
    ){
        this.speed = speed;
        this.m_ElevatorArmSubsystem = c_ElevatorArmSubsystem;
        addRequirements(c_ElevatorArmSubsystem);
    }
    //Stopping Arm Movement when between values below
@Override
  public void execute() {
      //  double current_pos = m_ElevatorArmSubsystem.getPos();
      //  m_ElevatorArmSubsystem.drive_to_pos(SmartDashboard.getNumber("Elevator Arm Value",-60)*1.4976, speed);
        if (current_pos > 2){//stop if at bottom or at top
            m_ElevatorArmSubsystem.p2(speed);
        } 
        else if(current_pos > 0 && speed<0){
            m_ElevatorArmSubsystem.p2(speed);
        }
        else{
            m_ElevatorArmSubsystem.p2(0);
        }
    }

    // @Override
    // public void initialize(){
    //     SmartDashboard.putNumber("Elevator Arm Value",m_ElevatorArmSubsystem.getPos());
    // }
}
