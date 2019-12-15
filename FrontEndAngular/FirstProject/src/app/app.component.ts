// import { Component } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import * as CanvasJS from './canvasjs.min';
import { ChartHandleService } from './ChartHandle/chart-handle.service';
import { RestService } from './rest/rest.service';
import { ChartData } from './chart-data';
import { Data } from './data';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  constructor(private chartHandle: ChartHandleService,
              private restService: RestService) { }

  kwota: number;
  okres: number;
  marza: number;
  wibor: number;
  prowizja: number;
  nadplata: number;
  opoznienieNadplaty: number;
  czestotliwoscNadplaty: number;
  rodzajNadplaty: string;

  public model: Data[];
  public isDataSet;
  title = 'Kallkulator kredytu hipotecznego';

  ngOnInit() {
    this.isDataSet = false;
  }

  click(event) {
    this.restService.calculate(this.kwota, this.okres, this.marza, this.wibor, this.prowizja).subscribe(data => {
      this.model = data;
      this.isDataSet = true;
      this.chartHandle.showChartRatyRowne(data[0].chartData);
      this.chartHandle.showChartRatyMalejace(data[1].chartData);
    });
  }
}


