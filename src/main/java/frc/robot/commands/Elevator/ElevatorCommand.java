package frc.robot.commands.Elevator;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Elevator.ElevatorSubsystem;
import frc.robot.subsystems.ShooterArm.ShooterSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ElevatorCommand extends Command{
    private final ElevatorSubsystem m_ElevatorSubsystem;
    private double m_speed1 = 0;
    public ElevatorCommand(
        ElevatorSubsystem c_ElevatorSubsystem,
        double c_speed1
        )
    {
        this.m_ElevatorSubsystem = c_ElevatorSubsystem;
        this.m_speed1 = c_speed1;
        addRequirements(m_ElevatorSubsystem);
    }
    
  
   // @Override
   // public void execute() {
   //     m_ElevatorSubsystem.run(m_speed1);
   //     
   // }

    @Override
        public void execute() {
        m_ElevatorSubsystem.run(m_speed1);
    }
}
